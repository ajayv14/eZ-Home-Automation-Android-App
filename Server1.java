import java.net.ServerSocket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.io.IOException;
import java.io.*;


import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

class  Server1{



public static void main(String[] args) throws IOException{


//Gpio controller

final GpioController gpio = GpioFactory.getInstance();
// set pin1 high

final GpioPinDigitalOutput pin1 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, "Relay1", PinState.HIGH );
final GpioPinDigitalOutput pin2 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "Relay2", PinState.HIGH );
final GpioPinDigitalOutput pin3 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02, "Relay3", PinState.HIGH );
final GpioPinDigitalOutput pin4 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03, "Relay4", PinState.HIGH );


ServerSocket svr = new ServerSocket(6000);

System.out.println("Server Started at port 6000");

try{

while(true)

{
Socket sc = svr.accept();

DataInputStream dIn = new DataInputStream(sc.getInputStream());


String va = dIn.readUTF();


System.out.println("VA successful" + va);

if(va.equals("a"))
{
System.out.println(" relay 1 ON");
pin1.low();//active low
}

if(va.equals("b"))
{
System.out.println(" relay 2 ON");
pin2.low();//active low
}

if(va.equals("c"))
{
System.out.println(" relay 3 ON");
pin3.low();//active low
}

if(va.equals("d"))
{
System.out.println(" relay 4 ON");
pin4.low();//active low
}

if(va.equals("a_off"))
{
System.out.println(" relay 1 OFF");
pin1.high();
}
if(va.equals("b_off"))
{
System.out.println(" relay 2 OFF");
pin2.high();
}
if(va.equals("c_off"))
{
System.out.println("relay 3 OFF");
pin3.high();
}
if(va.equals("d_off"))
{
System.out.println(" relay 4 OFF");
pin4.high();
}





DataOutputStream dOp =  new DataOutputStream(sc.getOutputStream());

dOp.writeUTF("Ping Successful");


}


}

catch(Exception e){

e.printStackTrace();

}


}


}
