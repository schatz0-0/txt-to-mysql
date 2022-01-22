package com.lin.command;

import org.jline.utils.AttributedString;
import org.springframework.shell.jline.PromptProvider;
import org.springframework.stereotype.Service;

/**
 * 自定义 shell 窗口命令提示符
 */
@Service
public class CustomPromptProvider implements PromptProvider{

	@Override
	public AttributedString getPrompt() {
		return new AttributedString("root:>");
	}

}
