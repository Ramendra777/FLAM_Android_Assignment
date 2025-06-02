precision mediump float;
uniform float time;
void main() {
    float glow = 0.5 + 0.5 * sin(time * 2.0);
    gl_FragColor = vec4(glow, glow * 0.8, 0.0, 1.0);
}