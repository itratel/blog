package com.yinhao.servlet;

import com.google.gson.Gson;
import com.yinhao.model.Message;
import com.yinhao.model.PageInfo;
import com.yinhao.service.IMessageService;
import com.yinhao.service.impl.MessageServiceImpl;
import com.yinhao.util.StrUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

import static com.yinhao.constant.Constants.*;

/**
 * <p>评论控制层</p>
 * @author yinhao
 * @date 2019/12/18 00:55
 */
@WebServlet(name = "message", urlPatterns = {"/servlet/message"})
public class MessageServlet extends HttpServlet {


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding(UTF8);
        response.setCharacterEncoding(UTF8);
        String action = request.getParameter(ACTION);
        switch (action) {
            case GET_PAGE:
                page(request, response);
                break;
            case DELETE:
                delete(request, response);
                break;
            case ADD:
                add(request, response);
                break;
            default:
                break;
        }
    }

    /***
     * 分页查询评论信息
     * @param request request
     * @param response response
     */
    private void page(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String strPageNum = request.getParameter(PAGE_NUM);
        String strPageSize = request.getParameter(PAGE_SIZE);
        String aId = request.getParameter("aId");
        //默认值
        int pageNum = StrUtil.isEmpty(strPageNum) ? MIN_PAGE_SIZE : Integer.parseInt(strPageNum);
        int pageSize = StrUtil.isEmpty(strPageSize) ? MAX_PAGE_SIZE : Integer.parseInt(strPageSize);
        IMessageService messageService = new MessageServiceImpl();
        //调用service 获取查询结果
        PageInfo<Message> result = messageService.listMessage(Integer.parseInt(aId), pageNum, pageSize);
        Gson gson = new Gson();
        String json = gson.toJson(result);
        response.getWriter().write(json);
    }

    /***
     * 删除评论
     * @param request request
     * @param response response
     * @throws ServletException
     * @throws IOException
     */
    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        IMessageService messageService = new MessageServiceImpl();
        String strId = request.getParameter(ID);
        int id = Integer.parseInt(strId);
        if (messageService.deleteMessage(id)) {
            response.getWriter().write(SUCCESS);
        } else {
            response.getWriter().write(FAIL);
        }
    }

    /***
     * 新增评论
     * @param request request
     * @param response response
     * @throws IOException
     */
    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        IMessageService messageService = new MessageServiceImpl();
        Message message = getMessage(request);
        if (messageService.addMessage(message)) {
            response.getWriter().write(SUCCESS);
        } else {
            response.getWriter().write(FAIL);
        }
    }

    /***
     * 从参数中获取评论内容
     * @param request request
     * @return Message
     */
    private Message getMessage(HttpServletRequest request) {
        String aId = request.getParameter(ARTICLE_ID);
        String content = request.getParameter(CONTENT);
        Message message = new Message();
        message.setaId(Integer.parseInt(aId));
        message.setContent(content);
        return message;
    }
}