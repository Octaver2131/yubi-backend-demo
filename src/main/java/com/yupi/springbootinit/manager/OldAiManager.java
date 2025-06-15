package com.yupi.springbootinit.manager;

import com.yupi.springbootinit.common.ErrorCode;
import com.yupi.springbootinit.exception.BusinessException;
import com.yupi.yucongming.dev.client.YuCongMingClient;
import com.yupi.yucongming.dev.common.BaseResponse;
import com.yupi.yucongming.dev.model.DevChatRequest;
import com.yupi.yucongming.dev.model.DevChatResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Deprecated
@Service
public class OldAiManager {

    @Resource
    private YuCongMingClient yuCongMingClient;

    /**
     * AI 聊天
     *
     * @param message
     * @return
     */
    public String doChat(String message) {
        DevChatRequest devChatRequest = new DevChatRequest();
        devChatRequest.setModelId(1651468516836098050L);
        devChatRequest.setMessage(message);
        BaseResponse<DevChatResponse> response = yuCongMingClient.doChat(devChatRequest);
        if (response == null) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR.getCode(),"AI 响应错误");
        }
        return response.getData().getContent();
    }
}
