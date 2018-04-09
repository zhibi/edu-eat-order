package school.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import school.domain.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class BaseController {

	protected Integer pageSize = 10;

	@Autowired
	protected HttpServletRequest request;
	@Autowired
	protected HttpSession session;

	protected String refresh() {
		return "redirect:" + request.getHeader("Referer");
	}

	/**
	 * 登录的管理员
	 * 
	 * @return
	 */
	protected User sessionUser() {
		return (User) session.getAttribute("sessionAdmin");
	}

	/**
	 * 保存文件
	 *
	 * @param file
	 * @return
	 */
	protected String saveFile(MultipartFile file) {
		String back = file.getOriginalFilename().substring(("." + file.getOriginalFilename()).lastIndexOf("."));
		String fileName = UUID.randomUUID() + "." + back;
		File newFile = new File(request.getServletContext().getRealPath("/data/") + "/" + fileName);
		newFile.getParentFile().mkdirs();
		try {
			newFile.createNewFile();
			file.transferTo(newFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("上传文件: " + newFile.getAbsolutePath());
		return "/data/" + fileName;
	}

	/**
	 * 登录的前台用户
	 * @return
	 */
	protected User frontUser() {
		return (User) session.getAttribute("sessionUser");
	}

}
