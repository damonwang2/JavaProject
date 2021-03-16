package IOAndNIO;

import java.io.IOException;
import java.nio.channels.SocketChannel;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public class SocketChannelTest {
    public static void main(String[] args) throws IOException, InterruptedException {

        SocketChannel socketChannel = SocketChannel.open();

        socketChannel.configureBlocking(false);
        Selector selector = Selector.open();
        socketChannel.register(selector, SelectionKey.OP_CONNECT);

        socketChannel.connect(new InetSocketAddress("127.0.0.1", 9000));

        while (true) {
            Thread.sleep(1000);
            int select = selector.select();

            if (select > 0) {

                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {

                    SelectionKey selectionKey = iterator.next();

                    if (selectionKey.isConnectable()) {
                        System.err.println("Connectable");
                        SocketChannel clientChannel = (SocketChannel) selectionKey.channel();
                        clientChannel.finishConnect();
                        selectionKey.interestOps(SelectionKey.OP_WRITE);

                    } else if (selectionKey.isReadable()) {
                        System.out.println("Readable");
                        SocketChannel channel = (SocketChannel) selectionKey.channel();
                        ByteBuffer buffer = ByteBuffer.allocate(128);
                        channel.read(buffer);
                        selectionKey.interestOps(SelectionKey.OP_WRITE);
                        System.out.println("收到服务端数据" + new String(buffer.array()));

                    } else if (selectionKey.isWritable()) {
                        System.out.println("Writable");
                        SocketChannel clientChannel = (SocketChannel) selectionKey.channel();
                        String str = "qiwoo mobile";
                        ByteBuffer buffer = ByteBuffer.wrap(str.getBytes());
                        clientChannel.write(buffer);
                        selectionKey.interestOps(SelectionKey.OP_READ);
                        System.out.println("向服务端发送数据" + new String(buffer.array()));
                    }

                    iterator.remove();
                }
            }
        }
    }
}