package com.werd.thegame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
//import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.werd.thegame.managers.MainMenuScreen;
import com.werd.thegame.objects.BackgroundActor;
import com.werd.thegame.objects.XMLparse;

import java.util.HashMap;

public class TheGame extends Game {
	public BitmapFont font, levels;
	private static final String FONT_CHARACTERS = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\/?-+=()*&.;,{}\"´`'<>";

	public BackgroundActor background;

	public HashMap<String, String> langStr = new HashMap<String, String>();
	SpriteBatch batch;
	Texture img;
	Texture img2;
	Texture img3;

	public TheGame() {
	}


	@Override
	public void create() {
//		batch = new SpriteBatch();
//		img = new Texture("badlogic.jpg");
//		img2 = new Texture("mario-jump-game.jpg");
//		img3 = new Texture("woman-running.jpg");

		//FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/russoone.ttf"));
		//FreeTypeFontParameter param = new FreeTypeFontParameter();
		//param.size = Gdx.graphics.getHeight() / 18;
		//param.characters = FONT_CHARACTERS;
		//font = generator.generateFont(param);
//		param.size = Gdx.graphics.getHeight() / 20;
//		levels = generator.generateFont(param);
//		font.setColor(Color.WHITE);
//		levels.setColor(Color.WHITE);
//		generator.dispose();
		font = new BitmapFont();
		font.getData().setScale( 2.9f,2.9f);
		font.setColor(Color.WHITE);
		//font.getRegion().getTexture().setFilter(TextureFilter.MipMap, TextureFilter.MipMap);
		levels = new BitmapFont();
		levels.getData().setScale( 1.9f,1.9f);
		levels.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
		levels.setColor(Color.WHITE);

		background = new BackgroundActor();
		background.setPosition(0, 0);

		XMLparse xmlParse = new XMLparse();
		String locale = java.util.Locale.getDefault().toString().split("_")[0];
		langStr = xmlParse.XMLparseLangs(locale);

		this.setScreen(new MainMenuScreen(this));
	}



	@Override
	public void render () {
//		// Link to colors http://prideout.net/archive/colors.php
//		Gdx.gl.glClearColor(1.000f, 1.000f, 0.878f, 1);
//		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//		batch.begin();
//		batch.draw(img, 0, 0);
//		batch.draw(img2, 300, 300);
//		batch.draw(img3, 600, 300);
//		batch.end();
		super.render();
	}

	@Override
	public void dispose () {
//		batch.dispose();
//		img.dispose();
//		img2.dispose();
//		img3.dispose();
	}
}
