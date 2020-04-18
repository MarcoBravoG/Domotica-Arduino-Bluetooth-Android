

package com.example.bluetooth1;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.UUID;
 
import com.example.bluetooth1.R;
 
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
 
 public class MainActivity extends Activity {
  private static final String TAG = "bluetooth1";

  Button Z1On,Z1Off, Z2On,Z2Off, Z3On,Z3Off, Z4On,Z4Off, Z5On,Z5Off, Z6On,Z6Off, Z7On,Z7Off,Z8On,Z8Off,
  P1On,P1Off, P2On,P2Off, P3On,P3Off, P4On,P4Off, V1On,V1Off, V2On,V2Off, V3On,V3Off;

  private BluetoothAdapter btAdapter = null;
  private BluetoothSocket btSocket = null;
  private OutputStream outStream = null;
   
  // SPP UUID service 
  private static final UUID MY_UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
 
  // MAC-address of Bluetooth module
  private static String address = "20:15:06:24:37:45";
   
  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
 
    setContentView(R.layout.activity_main);
    //Z1
    Z1On = (Button) findViewById(R.id.btnOn);
    Z1Off = (Button) findViewById(R.id.btnOff);
    //Z2
    Z2On  = (Button) findViewById(R.id.button1);
    Z2Off = (Button) findViewById(R.id.button2);
    //Z3
    Z3On  = (Button) findViewById(R.id.button3);
    Z3Off = (Button) findViewById(R.id.button4);
    //Z4
    Z4On  = (Button) findViewById(R.id.button5);
    Z4Off = (Button) findViewById(R.id.button6);
    //Z5
    Z5On  = (Button) findViewById(R.id.button7);
    Z5Off = (Button) findViewById(R.id.button8);
    //Z6
    Z6On  = (Button) findViewById(R.id.button9);
    Z6Off = (Button) findViewById(R.id.button10);
    //Z7
    Z7On  = (Button) findViewById(R.id.button11);
    Z7Off = (Button) findViewById(R.id.button12);
    //Z8
    Z8On  = (Button) findViewById(R.id.button13);
    Z8Off = (Button) findViewById(R.id.button14);    
    //P1
    P1On = (Button) findViewById(R.id.button15);
    P1Off = (Button) findViewById(R.id.button16);   
    //P2
    P2On = (Button) findViewById(R.id.Button01);
    P2Off = (Button) findViewById(R.id.Button02);    
    //P3
    P3On = (Button) findViewById(R.id.Button03);
    P3Off = (Button) findViewById(R.id.Button04);    
    //P4
    P4On = (Button) findViewById(R.id.Button05);
    P4Off = (Button) findViewById(R.id.Button06);
    //V1
    V1On = (Button) findViewById(R.id.Button07);
    V1Off = (Button) findViewById(R.id.Button08);
    //V2
    V2On = (Button) findViewById(R.id.Button09);
    V2Off = (Button) findViewById(R.id.Button010);
    //V3
    V3On = (Button) findViewById(R.id.Button011);
    V3Off = (Button) findViewById(R.id.Button012);
    btAdapter = BluetoothAdapter.getDefaultAdapter();
    checkBTState();
    
//Zona 1
    Z1On.setOnClickListener(new OnClickListener() {
      public void onClick(View v) {
        sendData("A");
        Toast.makeText(getBaseContext(), "Zona 1 Encendida", Toast.LENGTH_SHORT).show();
      }
    });
    Z1Off.setOnClickListener(new OnClickListener() {
      public void onClick(View v) {
        sendData("a");
        Toast.makeText(getBaseContext(), "Zona 1 Apagada", Toast.LENGTH_SHORT).show();
      }
    });  
//Zona 2
    Z2On.setOnClickListener(new OnClickListener() {
        public void onClick(View v) {
          sendData("B");
          Toast.makeText(getBaseContext(), "Zona 2 Encendida", Toast.LENGTH_SHORT).show();
        }
      }); 
      Z2Off.setOnClickListener(new OnClickListener() {
        public void onClick(View v) {
          sendData("b");
          Toast.makeText(getBaseContext(), "Zona 2 Apagada", Toast.LENGTH_SHORT).show();
        }
      });
//Zona 3
      Z3On.setOnClickListener(new OnClickListener() {
          public void onClick(View v) {
            sendData("C");
            Toast.makeText(getBaseContext(), "Zona 3 Encendida", Toast.LENGTH_SHORT).show();
          }
        });
        Z3Off.setOnClickListener(new OnClickListener() {
          public void onClick(View v) {
            sendData("c");
            Toast.makeText(getBaseContext(), "Zona 3 Apagada", Toast.LENGTH_SHORT).show();
          }
        });
//Zona 4
        Z4On.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
              sendData("D");
              Toast.makeText(getBaseContext(), "Zona 4 Encendida", Toast.LENGTH_SHORT).show();
            }
          });
          Z4Off.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
              sendData("d");
              Toast.makeText(getBaseContext(), "Zona 4 Apagada", Toast.LENGTH_SHORT).show();
            }
          });
//Zona 5
          Z5On.setOnClickListener(new OnClickListener() {
              public void onClick(View v) {
                sendData("E");
                Toast.makeText(getBaseContext(), "Zona 5 Encendida", Toast.LENGTH_SHORT).show();
              }
            });
            Z5Off.setOnClickListener(new OnClickListener() {
              public void onClick(View v) {
                sendData("e");
                Toast.makeText(getBaseContext(), "Zona 5 Apagada", Toast.LENGTH_SHORT).show();
              }
            });
//Zona 6
            Z6On.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                  sendData("F");
                  Toast.makeText(getBaseContext(), "Zona 6 Encendida", Toast.LENGTH_SHORT).show();
                }
              });
              Z6Off.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                  sendData("f");
                  Toast.makeText(getBaseContext(), "Zona 6 Apagada", Toast.LENGTH_SHORT).show();
                }
              });
//Zona 7
              Z7On.setOnClickListener(new OnClickListener() {
                  public void onClick(View v) {
                    sendData("G");
                    Toast.makeText(getBaseContext(), "Zona 7 Encendida", Toast.LENGTH_SHORT).show();
                  }
                });            
                Z7Off.setOnClickListener(new OnClickListener() {
                  public void onClick(View v) {
                    sendData("g");
                    Toast.makeText(getBaseContext(), "Zona 7 Apagada", Toast.LENGTH_SHORT).show();
                  }
                });
//Zona 8
                Z8On.setOnClickListener(new OnClickListener() {
                    public void onClick(View v) {
                      sendData("H");
                      Toast.makeText(getBaseContext(), "Zona 8 Encendida", Toast.LENGTH_SHORT).show();
                    }
                  });              
                  Z8Off.setOnClickListener(new OnClickListener() {
                    public void onClick(View v) {
                      sendData("h");
                      Toast.makeText(getBaseContext(), "Zona 8 Apagada", Toast.LENGTH_SHORT).show();
                    }
                  });                    
 //Puerta 1
                  P1On.setOnClickListener(new OnClickListener() {
                      public void onClick(View v) {
                        sendData("I");
                        Toast.makeText(getBaseContext(), "Purta 1 Abierta", Toast.LENGTH_SHORT).show();
                      }
                    });              
                    P1Off.setOnClickListener(new OnClickListener() {
                      public void onClick(View v) {
                        sendData("i");
                        Toast.makeText(getBaseContext(), "Puerta 1 Cerrada", Toast.LENGTH_SHORT).show();
                      }
                    });      
//Puerta 2
                    P2On.setOnClickListener(new OnClickListener() {
                        public void onClick(View v) {
                          sendData("J");
                          Toast.makeText(getBaseContext(), "Purta 2 Abierta", Toast.LENGTH_SHORT).show();
                        }
                      });              
                      P2Off.setOnClickListener(new OnClickListener() {
                        public void onClick(View v) {
                          sendData("j");
                          Toast.makeText(getBaseContext(), "Puerta 2 Cerrada", Toast.LENGTH_SHORT).show();
                        }
                      });      
//Puerta 3
                      P3On.setOnClickListener(new OnClickListener() {
                          public void onClick(View v) {
                            sendData("K");
                            Toast.makeText(getBaseContext(), "Purta 3 Abierta", Toast.LENGTH_SHORT).show();
                          }
                        });              
                        P3Off.setOnClickListener(new OnClickListener() {
                          public void onClick(View v) {
                            sendData("k");
                            Toast.makeText(getBaseContext(), "Puerta 3 Cerrada", Toast.LENGTH_SHORT).show();
                          }
                        });      
//Puerta 4
                        P4On.setOnClickListener(new OnClickListener() {
                            public void onClick(View v) {
                              sendData("L");
                              Toast.makeText(getBaseContext(), "Purta 4 Abierta", Toast.LENGTH_SHORT).show();
                            }
                          });              
                          P4Off.setOnClickListener(new OnClickListener() {
                            public void onClick(View v) {
                              sendData("l");
                              Toast.makeText(getBaseContext(), "Puerta 4 Cerrada", Toast.LENGTH_SHORT).show();
                            }
                          });                                     
//Ventana 1
                          V1On.setOnClickListener(new OnClickListener() {
                              public void onClick(View v) {
                                sendData("M");
                                Toast.makeText(getBaseContext(), "Ventana 1 Sube", Toast.LENGTH_SHORT).show();
                              }
                            });              
                            V1Off.setOnClickListener(new OnClickListener() {
                              public void onClick(View v) {
                                sendData("m");
                                Toast.makeText(getBaseContext(), "Ventana 1 baja", Toast.LENGTH_SHORT).show();
                              }
                            });                         
//Ventana 2
                            V2On.setOnClickListener(new OnClickListener() {
                                public void onClick(View v) {
                                  sendData("N");
                                  Toast.makeText(getBaseContext(), "Ventana 2 Sube", Toast.LENGTH_SHORT).show();
                                }
                              });              
                              V2Off.setOnClickListener(new OnClickListener() {
                                public void onClick(View v) {
                                  sendData("n");
                                  Toast.makeText(getBaseContext(), "Ventana 2 baja", Toast.LENGTH_SHORT).show();
                                }
                              });                         
//Ventana 3
                              V3On.setOnClickListener(new OnClickListener() {
                                  public void onClick(View v) {
                                    sendData("O");
                                    Toast.makeText(getBaseContext(), "Ventana 3 Sube", Toast.LENGTH_SHORT).show();
                                  }
                                });              
                                V3Off.setOnClickListener(new OnClickListener() {
                                  public void onClick(View v) {
                                    sendData("o");
                                    Toast.makeText(getBaseContext(), "Ventana 3 baja", Toast.LENGTH_SHORT).show();
                                  }
                                });                         
                          
                      
                      
                      
  }
  
  
  private BluetoothSocket createBluetoothSocket(BluetoothDevice device) throws IOException {
      if(Build.VERSION.SDK_INT >= 10){
          try {
              final Method  m = device.getClass().getMethod("createInsecureRfcommSocketToServiceRecord", new Class[] { UUID.class });
              return (BluetoothSocket) m.invoke(device, MY_UUID);
          } catch (Exception e) {
              Log.e(TAG, "Could not create Insecure RFComm Connection",e);
          }
      }
      return  device.createRfcommSocketToServiceRecord(MY_UUID);
  }
   
  @Override
  public void onResume() {
    super.onResume();
 
    Log.d(TAG, "...onResume - try connect...");
   
    // Set up a pointer to the remote node using it's address.
    BluetoothDevice device = btAdapter.getRemoteDevice(address);
   
    // Two things are needed to make a connection:
    //   A MAC address, which we got above.
    //   A Service ID or UUID.  In this case we are using the
    //     UUID for SPP.
   
	try {
		btSocket = createBluetoothSocket(device);
	} catch (IOException e1) {
		errorExit("Fatal Error", "In onResume() and socket create failed: " + e1.getMessage() + ".");
	}
    
    /*try {
      btSocket = device.createRfcommSocketToServiceRecord(MY_UUID);
    } catch (IOException e) {
      errorExit("Fatal Error", "In onResume() and socket create failed: " + e.getMessage() + ".");
    }*/
   
    // Discovery is resource intensive.  Make sure it isn't going on
    // when you attempt to connect and pass your message.
    btAdapter.cancelDiscovery();
   
    // Establish the connection.  This will block until it connects.
    Log.d(TAG, "...Connecting...");
    try {
      btSocket.connect();
      Log.d(TAG, "...Connection ok...");
    } catch (IOException e) {
      try {
        btSocket.close();
      } catch (IOException e2) {
        errorExit("Fatal Error", "In onResume() and unable to close socket during connection failure" + e2.getMessage() + ".");
      }
    }
     
    // Create a data stream so we can talk to server.
    Log.d(TAG, "...Create Socket...");
 
    try {
      outStream = btSocket.getOutputStream();
    } catch (IOException e) {
      errorExit("Fatal Error", "In onResume() and output stream creation failed:" + e.getMessage() + ".");
    }
  }
 
  @Override
  public void onPause() {
    super.onPause();
 
    Log.d(TAG, "...In onPause()...");
 
    if (outStream != null) {
      try {
        outStream.flush();
      } catch (IOException e) {
        errorExit("Fatal Error", "In onPause() and failed to flush output stream: " + e.getMessage() + ".");
      }
    }
 
    try     {
      btSocket.close();
    } catch (IOException e2) {
      errorExit("Fatal Error", "In onPause() and failed to close socket." + e2.getMessage() + ".");
    }
  }
   
  private void checkBTState() {
    // Check for Bluetooth support and then check to make sure it is turned on
    // Emulator doesn't support Bluetooth and will return null
    if(btAdapter==null) { 
      errorExit("Fatal Error", "Bluetooth not support");
    } else {
      if (btAdapter.isEnabled()) {
        Log.d(TAG, "...Bluetooth ON...");
      } else {
        //Prompt user to turn on Bluetooth
        Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
        startActivityForResult(enableBtIntent, 1);
      }
    }
  }
 
  private void errorExit(String title, String message){
    Toast.makeText(getBaseContext(), title + " - " + message, Toast.LENGTH_LONG).show();
    finish();
  }
 
  private void sendData(String message) {
    byte[] msgBuffer = message.getBytes();
 
    Log.d(TAG, "...Send data: " + message + "...");
 
    try {
      outStream.write(msgBuffer);
    } catch (IOException e) {
      String msg = "In onResume() and an exception occurred during write: " + e.getMessage();
      if (address.equals("00:00:00:00:00:00")) 
        msg = msg + ".\n\nUpdate your server address from 00:00:00:00:00:00 to the correct address on line 35 in the java code";
      	msg = msg +  ".\n\nCheck that the SPP UUID: " + MY_UUID.toString() + " exists on server.\n\n";
       
      	errorExit("Fatal Error", msg);       
    }
  }
}

