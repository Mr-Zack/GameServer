package info.xiaomo.server.processor;


import info.xiaomo.gameCore.base.concurrent.command.IQueueDriverCommand;
import info.xiaomo.gameCore.network.IProcessor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 登录消息处理器
 *
 * @author Administrator
 */
@Slf4j
public class LoginProcessor implements IProcessor {

    private Executor executor = Executors.newSingleThreadExecutor(r -> new Thread(r, "Login"));

    @Override
    public void process(IQueueDriverCommand handler) {
        this.executor.execute(handler);
    }

}
