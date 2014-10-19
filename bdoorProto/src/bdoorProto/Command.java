/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdoorProto;

/**
 *
 * @author yur
 * @param <REQ>
 * @param <REP>
 */
public class Command<REQ extends Request, REP extends Reply> {
	protected REQ req;
	protected REP rep;
	
}
