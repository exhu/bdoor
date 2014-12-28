/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdoorProto;

/**
 *
 * @author yur
 */
public final class PacketHeader {

    public static final int headerSize = 4 * 3;
    public int dataSize = headerSize; // size in bytes of packet data (including id, command etc.)
    public int id = 0; // new for request, negative for reply
    public int command = -1; // zero is reverved for PingCommand
}
