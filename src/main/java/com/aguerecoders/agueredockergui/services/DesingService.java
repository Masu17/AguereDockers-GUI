package com.aguerecoders.agueredockergui.services;

import javafx.scene.SnapshotParameters;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class DesingService {
    public static void imageSetter(ImageView waveImage) {
        Rectangle clip = new Rectangle(
                waveImage.getFitWidth(), waveImage.getFitHeight()
        );
        clip.setArcWidth(50);
        clip.setArcHeight(50);
        waveImage.setClip(clip);

        SnapshotParameters parameters = new SnapshotParameters();
        parameters.setFill(Color.TRANSPARENT);
        WritableImage image = waveImage.snapshot(parameters, null);

        waveImage.setClip(null);
        waveImage.setEffect(new DropShadow(20, Color.BLACK));
        waveImage.setImage(image);
    }
}
