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
public abstract class Request extends Packet {

    Request(PacketHeader h) {
        super(h);
    }
}
