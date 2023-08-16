package gerencia.hotel.Service;

import com.fazecast.jSerialComm.*;

public class ArduinoSerialCommunication {
    private SerialPort serialPort;

    public void initialize() {
        // Listar as portas seriais disponíveis
        SerialPort[] ports = SerialPort.getCommPorts();
        if (ports.length == 0) {
            System.out.println("Nenhuma porta serial encontrada.");
            return;
        }

        // Escolher a porta serial adequada (pode variar de acordo com o sistema operacional)
        SerialPort port = ports[0]; // Utilizando a primeira porta encontrada

        // Abrir a porta serial
        port.openPort();
        port.setComPortParameters(9600, 8, 1, 0); // Configurar a velocidade de comunicação e outros parâmetros
        port.addDataListener(new SerialPortDataListener() {
            @Override
            public int getListeningEvents() {
                return SerialPort.LISTENING_EVENT_DATA_AVAILABLE;
            }

            @Override
            public void serialEvent(SerialPortEvent event) {
                if (event.getEventType() == SerialPort.LISTENING_EVENT_DATA_AVAILABLE) {
                    byte[] newData = new byte[port.bytesAvailable()];
                    int numRead = port.readBytes(newData, newData.length);
                    String receivedData = new String(newData);
                    System.out.println("Dados recebidos: " + receivedData);
                }
            }
        });

        System.out.println("Porta serial aberta com sucesso.");
    }

    public static void main(String[] args) {
        ArduinoSerialCommunication communication = new ArduinoSerialCommunication();
        communication.initialize();
    }
}
