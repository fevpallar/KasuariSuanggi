package com.fevly.simulation.projection;

import static com.jogamp.opengl.GL.GL_ARRAY_BUFFER;
import static com.jogamp.opengl.GL.GL_STATIC_DRAW;
import static com.jogamp.opengl.GL2ES2.GL_FRAGMENT_SHADER;
import static com.jogamp.opengl.GL2ES2.GL_VERTEX_SHADER;

import com.jogamp.common.nio.Buffers;
import com.jogamp.opengl.GL4;
import com.jogamp.opengl.GLContext;
import com.jogamp.opengl.math.Matrix4f;

import java.nio.FloatBuffer;
import java.util.LinkedHashMap;
import java.util.Map;
/*============================================
Author : Fevly pallar
Contact : fevly.pallar@gmail.com

30042024

Current issue :

- Graphic drivernya Intel versi lama bikin error somewhere di support *.dllnya (Windows)

Jgn lupa Attach :

Dsun.java2d.noddraw=true di run config.
Dsun.java2d.d3d=false

Ini supaya hardware accelaration disabled
============================================== */
public class ModelBuilder {
    private GL4 glContext;
    private int modelViewLocation, perpectiveLocation;
    private int prog;
    FloatBuffer bufferVertex;

    public ModelBuilder() {
        buildMatrixList();
        glContext = (GL4) GLContext.getCurrentGL();
        prog = getProg();

        glContext.glGenVertexArrays(Constant.vertextArrayObj.length, Constant.vertextArrayObj, 0);
        glContext.glBindVertexArray(Constant.vertextArrayObj[0]);

        //VBOs --store-->  positions, colors, texture coordinates, normals, etc. associated with vertices.
        glContext.glGenBuffers(Constant.vertexBufferObj.length, Constant.vertexBufferObj, 0);
        glContext.glBindBuffer(GL_ARRAY_BUFFER, Constant.vertexBufferObj[0]);

     //    ke GPU internal OpenGL
        bufferVertex = Buffers.newDirectFloatBuffer(Constant.vertexPos);
        glContext.glBufferData(GL_ARRAY_BUFFER, bufferVertex.limit() * 4, bufferVertex, GL_STATIC_DRAW);
    }

    Map<Integer, Matrix4f> mapMatrix = new LinkedHashMap();

    public Matrix4f getNewMatrix() {

        return new Matrix4f();
    }


    public void buildMatrixList() {
        mapMatrix.put(0, getNewMatrix()); // model
        mapMatrix.put(0, getNewMatrix()); // view
        mapMatrix.put(0, getNewMatrix()); // model-view
        mapMatrix.put(0, getNewMatrix());// perspective/projeksi
    }


    public GL4 getGLContext() {
        return this.glContext;
    }


    public int getProg() {
        int vertextShader = glContext.glCreateShader(GL_VERTEX_SHADER);
        glContext.glShaderSource(vertextShader, 1, Constant.vertexShader, null, 0);
        glContext.glCompileShader(vertextShader);
        int fragShadder = glContext.glCreateShader(GL_FRAGMENT_SHADER);
        glContext.glShaderSource(fragShadder, 1, Constant.fragShader, null, 0);
        glContext.glCompileShader(fragShadder);
        int prog = glContext.glCreateProgram();
        glContext.glAttachShader(prog, vertextShader);
        glContext.glAttachShader(prog, fragShadder);
        glContext.glLinkProgram(prog);
        glContext.glDeleteShader(vertextShader);
        glContext.glDeleteShader(fragShadder);
        return prog;
    }
}
