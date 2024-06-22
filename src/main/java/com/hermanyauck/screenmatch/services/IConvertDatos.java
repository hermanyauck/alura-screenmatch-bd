package com.hermanyauck.screenmatch.services;

public interface IConvertDatos {

    <T> T obtenerDatos(String json, Class<T> clase);

}
