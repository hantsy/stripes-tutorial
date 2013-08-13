/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial.action;

import com.octo.captcha.service.image.DefaultManageableImageCaptchaService;
import com.octo.captcha.service.image.ImageCaptchaService;

/**
 *
 * @author hantsy
 */
public class CaptchaManager {

    private static ImageCaptchaService imageCaptchaService = new DefaultManageableImageCaptchaService();

    public static ImageCaptchaService get() {
        return imageCaptchaService;
    }
}