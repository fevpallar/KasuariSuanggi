package com.fevly.simulation.projection;
/*============================================
Author : Fevly pallar
Contact : fevly.pallar@gmail.com


* untuk simulasi object. Current implementation pakai dummy cube.
=========================================================== */
public class Constant {
  static int vertextArrayObj [] = new int [1];
  static int vertexBufferObj [] = new int [1];
    public static final String vertexShader [] =
    {
            "layout (location=0) in vec3 position;\n" +
            // hold (model & view) matrix
            "uniform mat4 mv_matrix;\n" +

            //  variasi warna pada cube
            "out vec4 varyingColor;\n" +
            // hold projection/perspective matrix
            "uniform mat4 p_matrix;\n" +

            "void main(void)\n" +

                        /*=========================================
                        Key :  vector(point) * matriks = vector(point) baru.

                        so :
                        projection/perspective matriks * model+view matriks * posisi
                         * posisi ini  vektor/point itu
                        ========================================= */

            "{ gl_Position = p_matrix * mv_matrix * vec4(position, 1.0);\n" +
            //  variasi warna saja
            "varyingColor = vec4(position,1.0) * 0.5 + vec4(0.5, 0.7, 0.9, 0.3);" +
            "}"
    };

    public static final String fragShader [] =
            {
                    "out vec4 color;\n" +
                    "in vec4 varyingColor;\n" +
                    "void main(void)\n" +
                    "{ "+
                    "color = varyingColor; }"
            };
    private   final  float objX= 0.0f, objY = 0.0f, objZ= 0.7f;
    private  final float camX= 0, camY = 0, camZ= 10.0f;

    static float[] vertexPos =
            {-1.0f, 1.0f, -1.0f, -1.0f, -1.0f, -1.0f, 1.0f, -1.0f, -1.0f,
                    1.0f, -1.0f, -1.0f, 1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f,
                    1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f,
                    1.0f, -1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, -1.0f,
                    1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, 1.0f,

                    -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f,
                    -1.0f, -1.0f, 1.0f, -1.0f, -1.0f, -1.0f, -1.0f, 1.0f, 1.0f,
                    -1.0f, -1.0f, -1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f,
                    -1.0f, -1.0f, 1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f, -1.0f,
                    1.0f, -1.0f, -1.0f, -1.0f, -1.0f, -1.0f, -1.0f, -1.0f, 1.0f,
                    -1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f, 1.0f, 1.0f, 1.0f,
                    1.0f, 1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f, 1.0f, -1.0f
            };
}
