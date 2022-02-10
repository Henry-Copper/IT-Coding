package com.codewithmosh;

public class TextBox extends UIControl
{

protected int a;

private String text = "";

public TextBox()
{

super(true);
System.out.println("TextBox");

}

public void setText(String text) {this.text = text;}

protected void clear() {text = "";}

}