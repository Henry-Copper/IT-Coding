package com.codewithmosh;

public class UIControl
{
private boolean isEnabled = true;

   public static void main(String[] args)
   {
   
   }

   public void enable()
   {
   isEnabled = true;
   }
   
   public void disable()
   {
   isEnabled = false;
   }
   
   
   public boolean isEnabled()
   {
   return isEnabled;
   }
   
}