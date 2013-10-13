package com.gmail.cfretz244;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class Vanity extends JavaPlugin {
	
	@Override
	public void onEnable() {
		//Do something awesome
	}
	
	@Override
	public void onDisable() {
		
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("vanity")) {
			if(sender instanceof Player) {
				if(args.length == 2) {
					Player player = (Player)sender;
					int width = Integer.parseInt(args[0]), height = Integer.parseInt(args[1]);
					try {
						InputStream stream = this.getClass().getResourceAsStream("/pic.jpg");
						BufferedImage img = ImageIO.read(stream);
						img = resizeImage(img, width, height);
						int[][] woolColors = processImage(img);
					} catch(IOException e) {
						//do something
					} catch(Exception e) {
						//do something
					}
				} else {
					sender.sendMessage("Wrong number of parameters");
				}
			}
		} else {
			sender.sendMessage("Wrong command");
		}
		return false;
	}
	
	public int[][] processImage(BufferedImage img) {
		int[][] pixelData = new int[img.getWidth()][img.getHeight()];
		for(int i = 0; i < img.getWidth(); i++) {
			for(int k = 0; k < img.getHeight(); k++) {
				Color currentPixel = new Color(img.getRGB(i, k));
				int r = currentPixel.getRed();
				int g = currentPixel.getGreen();
				int b = currentPixel.getBlue();
				if((r >= 200 && r <= 250) && (g >= 200 && g <= 250) && (b >= 200 && b <= 200)) {
					pixelData[i][k] = 0;
				} else if((r >= 140 && r <= 190) && (g >= 140 && g <= 190) && (b >= 140 && b <= 190)) {
					pixelData[i][k] = 1;
				} else if((r >= 40 && r <= 90) && (g >= 40 && g <= 90) && (b >= 40 && b <= 90)) {
					pixelData[i][k] = 2;
				} else if((r >= 0 && r <= 40) && (g >= 0 && g <= 40) && (b >= 0 && b <= 40)) {
					pixelData[i][k] = 3;
				} else if((r >= 135 && r <= 185) && (g >= 30 && g <= 80) && (b >= 30 && b <= 80)) {
					pixelData[i][k] = 4;
				} else if((r >= 195 && r <= 245) && (g >= 100 && g <= 150) && (b >= 35 && b <= 85)) {
					pixelData[i][k] = 5;
				} else if((r >= 165 && r <= 215) && (g >= 155 && g <= 205) && (b >= 15 && b <= 65)) {
					pixelData[i][k] = 6;
				} else if((r >= 40 && r <= 90) && (g >= 150 && g <= 200) && (b >= 35 && b <= 85)) {
					pixelData[i][k] = 7;
				} else if((r >= 35 && r <= 85) && (g >= 55 && g <= 105) && (b >= 5 && b <= 55)) {
					pixelData[i][k] = 8;
				} else if((r >= 65 && r <= 115) && (g >= 100 && g <= 150) && (b >= 170 && b <= 220)) {
					pixelData[i][k] = 9;
				} else if((r >= 25 && r <= 75) && (g >= 90 && g <= 140) && (b >= 115 && b <= 165)) {
					pixelData[i][k] = 10;
				} else if((r >= 20 && r <= 70) && (g >= 30 && g <= 80) && (b >= 110 && b <= 160)) {
					pixelData[i][k] = 11;
				} else if((r >= 95 && r <= 145) && (g >= 35 && g <= 85) && (b >= 155 && b <= 205)) {
					pixelData[i][k] = 12;
				} else if((r >= 150 && r <= 200) && (g >= 45 && g <= 95) && (b >= 160 && b <= 210)) {
					pixelData[i][k] = 13;
				} else if((r >= 185 && r <= 235) && (g >= 115 && g <= 165) && (b >= 135 && b <= 185)) {
					pixelData[i][k] = 14;
				} else if((r >= 50 && r <= 100) && (g >= 25 && g <= 75) && (b >= 5 && b <= 5)) {
					pixelData[i][k] = 15;
				} else {
					pixelData[i][k] = -1;
				}
			}
		}
		
		return pixelData;
	}
	
	public BufferedImage resizeImage(BufferedImage img, int newWidth, int newHeight) {
		int type = img.getType();
		BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, type);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(img, 0, 0, newWidth, newHeight, null);
		g.dispose();
		return resizedImage;
	}
	
	
}
