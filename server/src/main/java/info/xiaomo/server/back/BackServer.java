package info.xiaomo.server.back;

import info.xiaomo.gameCore.network.NetworkService;
import info.xiaomo.gameCore.network.NetworkServiceBuilder;
import info.xiaomo.gameCore.network.pool.MessageRouter;
import info.xiaomo.server.server.ServerOption;

/**
 * 把今天最好的表现当作明天最新的起点．．～
 * いま 最高の表現 として 明日最新の始発．．～
 * Today the best performance  as tomorrow newest starter!
 * Created by IntelliJ IDEA.
 * <p>
 * author: xiaomo
 * github: https://github.com/xiaomoinfo
 * email: xiaomo@xiaomo.info
 * QQ_NO: 83387856
 * Date: 2016/11/24 10:11
 * Copyright(©) 2015 by xiaomo.
 **/

public class BackServer {

    private NetworkService service;

    public BackServer(ServerOption option) {
        BackIMessageAndHandler pool = new BackIMessageAndHandler();
        int bossLoopGroupCount = 4;
        int workerLoopGroupCount = 4;
        NetworkServiceBuilder builder = new NetworkServiceBuilder();
        builder.setBossLoopGroupCount(bossLoopGroupCount);
        builder.setWorkerLoopGroupCount(workerLoopGroupCount);
        builder.setPort(option.getBackServerPort());
        builder.setIMessageAndHandler(pool);
        builder.setConsumer(new MessageRouter(pool));

        service = builder.createService();
    }

    public void start() {
        service.start();
    }

    public void stop() {
        service.stop();
    }
}