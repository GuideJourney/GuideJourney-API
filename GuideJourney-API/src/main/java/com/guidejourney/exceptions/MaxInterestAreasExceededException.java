package com.guidejourney.exceptions;

public class MaxInterestAreasExceededException extends RuntimeException {
    public MaxInterestAreasExceededException() {
        super("Puedes seleccionar hasta 5 áreas de interés");
    }
}
