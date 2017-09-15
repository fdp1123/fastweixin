package com.taxi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.sd4324530.fastweixin.message.BaseMsg;
import com.github.sd4324530.fastweixin.message.ImageMsg;
import com.github.sd4324530.fastweixin.message.TextMsg;
import com.github.sd4324530.fastweixin.message.req.BaseEvent;
import com.github.sd4324530.fastweixin.message.req.ImageReqMsg;
import com.github.sd4324530.fastweixin.message.req.MenuEvent;
import com.github.sd4324530.fastweixin.message.req.TemplateMsgEvent;
import com.github.sd4324530.fastweixin.servlet.WeixinControllerSupport;

/**
 * @author 王治
 * @function fastweixin控制类
 * @date 2017年7月18日
 */
@RestController
@RequestMapping("/fastweixin")
public class WeChatController extends WeixinControllerSupport {
	private static final Logger LOG = LoggerFactory.getLogger(WeChatController.class);
	private static final String TOKEN = "yd1503c"; // 令牌
	private static final String APPID = "wx2f9cdd6430278db7";// 开发者ID(AppID)
	// 消息加解密密钥
	private static final String ENCODINGAESKEY = "KAnGtZ1eswSKu95zAubvqHVRrq1ntP8TE8fkLcg3hpO";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.github.sd4324530.fastweixin.servlet.WeixinSupport#handleImageMsg(com.
	 * github.sd4324530.fastweixin.message.req.ImageReqMsg)
	 */
	@Override
	protected BaseMsg handleImageMsg(ImageReqMsg msg) {
		// 图来图往
		ImageMsg imageMsg = new ImageMsg(msg.getMediaId());
		return imageMsg;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.sd4324530.fastweixin.servlet.WeixinSupport#
	 * handleTemplateMsgEvent(com.github.sd4324530.fastweixin.message.req.
	 * TemplateMsgEvent)
	 */
	@Override
	protected BaseMsg handleTemplateMsgEvent(TemplateMsgEvent event) {
		// TODO Auto-generated method stub
		return super.handleTemplateMsgEvent(event);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.github.sd4324530.fastweixin.servlet.WeixinSupport#
	 * handleMenuClickEvent(com.github.sd4324530.fastweixin.message.req.
	 * MenuEvent)
	 */
	@Override
	protected BaseMsg handleMenuClickEvent(MenuEvent event) {
		return handleMenuClickEvent(event);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.github.sd4324530.fastweixin.servlet.WeixinSupport#handleDefaultEvent(
	 * com.github.sd4324530.fastweixin.message.req.BaseEvent)
	 */
	@Override
	protected BaseMsg handleDefaultEvent(BaseEvent event) {
		// LOG.info("-------->" + event.getEvent());
		// if (event instanceof LocationEvent) {
		// LocationEvent location = (LocationEvent) event;
		// LOG.info("log:经度:" + location.getLongitude() + "纬度:" +
		// location.getLatitude());
		// }
		return super.handleDefaultEvent(event);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.github.sd4324530.fastweixin.servlet.WeixinSupport#handleSubscribe(com
	 * .github.sd4324530.fastweixin.message.req.BaseEvent)
	 */
	@Override
	protected BaseMsg handleSubscribe(BaseEvent event) {
		LOG.info(event.getFromUserName() + "关注了该公众号");
		return new TextMsg("Dear,您很有品味哦!这里是八维出租车!谢谢你这儿有眼光,关注我们.我们竭诚为您提供高效,安全地打车体验~");
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.github.sd4324530.fastweixin.servlet.WeixinSupport#getAppId()
	 */
	@Override
	protected String getAppId() {
		return APPID;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.github.sd4324530.fastweixin.servlet.WeixinSupport#getToken()
	 */
	@Override
	protected String getToken() {
		return TOKEN;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.sd4324530.fastweixin.servlet.WeixinSupport#getAESKey()
	 */
	@Override
	protected String getAESKey() {
		return ENCODINGAESKEY;
	}

}










