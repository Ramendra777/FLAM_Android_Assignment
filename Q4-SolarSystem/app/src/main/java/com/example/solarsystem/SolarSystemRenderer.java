package com.example.solarsystem;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;

public class SolarSystemRenderer implements GLSurfaceView.Renderer {
    private final Context context;
    private Sphere sun, planet1, planet2, moon;
    private int sunProgram, planetProgram;
    private float[] projectionMatrix = new float[16];
    private float[] viewMatrix = new float[16];
    private float[] modelMatrix = new float[16];
    private float[] mvpMatrix = new float[16];
    private float angle = 0f;

    public SolarSystemRenderer(Context context) {
        this.context = context;
    }

    @Override
    public void onSurfaceCreated(javax.microedition.khronos.egl.EGLConfig config) {
        GLES20.glClearColor(0f, 0f, 0f, 1f);
        GLES20.glEnable(GLES20.GL_DEPTH_TEST);

        sunProgram = ShaderUtils.createProgram(
                ShaderUtils.readRawTextFile(context, R.raw.sun_vertex),
                ShaderUtils.readRawTextFile(context, R.raw.sun_fragment));

        planetProgram = ShaderUtils.createProgram(
                ShaderUtils.readRawTextFile(context, R.raw.planet_vertex),
                ShaderUtils.readRawTextFile(context, R.raw.planet_fragment));

        sun = new Sphere(1f);
        planet1 = new Sphere(0.4f);
        planet2 = new Sphere(0.3f);
        moon = new Sphere(0.1f);
    }

    @Override
    public void onSurfaceChanged(javax.microedition.khronos.opengles.GL10 gl, int width, int height) {
        GLES20.glViewport(0, 0, width, height);
        float ratio = (float) width / height;
        Matrix.frustumM(projectionMatrix, 0, -ratio, ratio, -1, 1, 2, 100);
        Matrix.setLookAtM(viewMatrix, 0, 0, 0, 10, 0, 0, 0, 0, 1, 0);
    }

    @Override
    public void onDrawFrame(javax.microedition.khronos.opengles.GL10 gl) {
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT | GLES20.GL_DEPTH_BUFFER_BIT);
        angle += 0.5f;

        drawSphere(sun, sunProgram, 0, 0, 0);

        float x1 = (float) Math.cos(Math.toRadians(angle)) * 4;
        float z1 = (float) Math.sin(Math.toRadians(angle)) * 4;
        drawSphere(planet1, planetProgram, x1, 0, z1);

        float x2 = (float) Math.cos(Math.toRadians(angle * 0.5)) * 6;
        float z2 = (float) Math.sin(Math.toRadians(angle * 0.5)) * 6;
        drawSphere(planet2, planetProgram, x2, 0, z2);

        float mx = x2 + (float) Math.cos(Math.toRadians(angle * 2)) * 1.0f;
        float mz = z2 + (float) Math.sin(Math.toRadians(angle * 2)) * 1.0f;
        drawSphere(moon, planetProgram, mx, 0, mz);
    }

    private void drawSphere(Sphere sphere, int program, float x, float y, float z) {
        GLES20.glUseProgram(program);
        Matrix.setIdentityM(modelMatrix, 0);
        Matrix.translateM(modelMatrix, 0, x, y, z);
        Matrix.multiplyMM(mvpMatrix, 0, viewMatrix, 0, modelMatrix, 0);
        Matrix.multiplyMM(mvpMatrix, 0, projectionMatrix, 0, mvpMatrix, 0);

        int mvpHandle = GLES20.glGetUniformLocation(program, "u_MVPMatrix");
        GLES20.glUniformMatrix4fv(mvpHandle, 1, false, mvpMatrix, 0);

        sphere.draw(program);
    }
}
