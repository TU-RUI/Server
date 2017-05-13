package com.server.utils;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;

public class ImageCompress {

	public static ByteArrayOutputStream compressImage(BufferedImage image,
			float quality) throws IOException {
		// Get a ImageWriter for jpeg format.
		Iterator<ImageWriter> writers = ImageIO.getImageWritersBySuffix("jpeg");
		if (!writers.hasNext())
			throw new IllegalStateException("No writers found");
		ImageWriter writer = (ImageWriter) writers.next();

		while (!writer.getDefaultWriteParam().canWriteCompressed()
				&& writers.next() != null) {
			writer = writers.next();
		}

		// Create the ImageWriteParam to compress the image.
		ImageWriteParam param = writer.getDefaultWriteParam();

		param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
		param.setCompressionQuality(quality);

		// The output will be a ByteArrayOutputStream (in memory)
		ByteArrayOutputStream bos = new ByteArrayOutputStream(32768);
		ImageOutputStream ios = ImageIO.createImageOutputStream(bos);
		writer.setOutput(ios);
		writer.write(null, new IIOImage(image, null, null), param);
		ios.flush();
		return bos;
	}

}
