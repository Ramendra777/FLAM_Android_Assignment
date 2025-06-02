package com.example.solarsystem;

import android.opengl.GLES20;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class Sphere {
    private FloatBuffer vertexBuffer;
    private int vertexCount;
    private static final int COORDS_PER_VERTEX = 3;

    public Sphere(float radius) {
        int stacks = 20, slices = 20;
        float[] vertices = new float[stacks * slices * 6 * COORDS_PER_VERTEX];
        int idx = 0;

        for (int i = 0; i < stacks; ++i) {
            float phi1 = (float) (Math.PI * i / stacks);
            float phi2 = (float) (Math.PI * (i + 1) / stacks);
            for (int j = 0; j <= slices; ++j) {
                float theta = (float) (2 * Math.PI * j / slices);
                for (int k = 0; k < 2; ++k) {
                    float phi = k == 0 ? phi1 : phi2;
                    float x = (float) (radius * Math.sin(phi) * Math.cos(theta));
                    float y = (float) (radius * Math.cos(phi));
                    float z = (float) (radius * Math.sin(phi) * Math.sin(theta));
                    vertices[idx++] = x;
                    vertices[idx++] = y;
                    vertices[idx++] = z;
                }
            }
        }

        vertexCount = idx / COORDS_PER_VERTEX;
        ByteBuffer bb = ByteBuffer.allocateDirect(vertices.length * 4);
        bb.order(ByteOrder.nativeOrder());
        vertexBuffer = bb.asFloatBuffer();
        vertexBuffer.put(vertices);
        vertexBuffer.position(0);
    }

    public void draw(int program) {
        int positionHandle = GLES20.glGetAttribLocation(program, "a_Position");
        GLES20.glEnableVertexAttribArray(positionHandle);
        GLES20.glVertexAttribPointer(positionHandle, COORDS_PER_VERTEX, GLES20.GL_FLOAT, false, 0, vertexBuffer);
        GLES20.glDrawArrays(GLES20.GL_TRIANGLE_STRIP, 0, vertexCount);
        GLES20.glDisableVertexAttribArray(positionHandle);
    }
}
