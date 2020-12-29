package cn.jvtd.netty.demo.controller;

import cn.chenzw.sms.core.Session;
import cn.chenzw.sms.core.protocol.cmpp.CMPPConnection;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * @author Aaronglyang
 */
@Slf4j
public class Cmpp {
//    public static void main(String[] args){
//        CMPPConnection conn = new CMPPConnection();
//        conn.setSourceAddr("110110");
//        conn.setPassword("ICP");
//        conn.setVersion((byte) 0);
//        conn.setAutoReconnect(true);
//        conn.setSendInterval(200);
//
//        conn.connect("47.94.81.144", 7890);
//
//        if (conn.isConnected()) {
//            Session session = conn.getSession();
//            String[] phones = new String[]{"15010559357"};
//
//            long startTime = System.currentTimeMillis();
//            try {
//                for (int i = 0; i < phones.length * 10; i++) {
//                    String content = String.format("第%d条:电信cmpp测试X(%s)", i + 1, new Date().toString());
//                    session.submit(content, "1065902100612", phones[i / 10]);
//
//                }
//            } finally {
//                log.info(String.format("total:%d", System.currentTimeMillis() - startTime));
//            }
//        }
//    }
}
