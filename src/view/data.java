/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Raphael
 */
public class data {

    
   String mes, dia, ano, dia_semana, hora;
   SimpleDateFormat horaformatada = new SimpleDateFormat("HH:mm:ss");
   
   public void le_hora()
   {
       Date horaAtual = new Date();
       hora = horaformatada.format(horaAtual);
   }
   
   public void le_data()
   {
       Date data = new Date();
     //  mes = ""+data.getMonth(); //0 a 11
       dia = ""+data.getDate();
       ano = ""+(1900 + data.getYear());
     //  dia_semana = ""+data.getDay(); // 0 a 6;
       
       switch(data.getDay())
       {
           case 0: dia_semana = "Domingo";break;
           case 1: dia_semana = "Segunda";break;
           case 2: dia_semana = "Terca";break;
           case 3: dia_semana = "Quarta";break;
           case 4: dia_semana = "Quinta";break;
           case 5: dia_semana = "Sexta";break;
           case 6: dia_semana = "Sábado";break;    
       }    
       
       switch(data.getMonth())
       {
           case 0: mes = "Janeiro";break;
           case 1: mes = "Fevereiro";break;    
           case 2: mes = "Marco";break;
           case 3: mes = "Abril";break;    
           case 4: mes = "Maio";break;    
           case 5: mes = "Junho";break;    
           case 6: mes = "Julho";break;    
           case 7: mes = "Agosto";break;    
           case 8: mes = "Setembro";break;    
           case 9: mes = "Outubro";break;    
           case 10: mes = "Novembro";break;
           case 11: mes = "Dezembro";break;    
               
       }
   }           
}



   
