package com.premsh.visitorsure.component;

import java.lang.reflect.Type;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;

@Component
public class Converter {


	public String convert(Object obj) {
		return new Gson().toJson(obj);
	}
	public String convert(Object obj, Type type) {
		return new Gson().toJson(obj, type);
	}
}
