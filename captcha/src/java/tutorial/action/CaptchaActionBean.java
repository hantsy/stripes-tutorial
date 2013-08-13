/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial.action;

import com.octo.captcha.service.CaptchaServiceException;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.DontValidate;
import net.sourceforge.stripes.action.HttpCache;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.StreamingResolution;
import net.sourceforge.stripes.action.UrlBinding;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author hantsy
 */

public class CaptchaActionBean extends BaseActionBean {

    private final static Log log = LogFactory.getLog(CaptchaActionBean.class);

    @DontValidate
    @DefaultHandler
    @HttpCache(allow=false)
    public Resolution display() {

        byte[] captchaChallengeAsJpeg = null;
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        try {
            String captchaId = getContext().getRequest().getSession().getId();
            if (log.isDebugEnabled()) {
                log.debug("=================" + captchaId + "==================");
            }
            BufferedImage challenge = CaptchaManager.get().getImageChallengeForID(captchaId, getContext().getLocale());
            JPEGImageEncoder jpegEncoder = JPEGCodec.createJPEGEncoder(jpegOutputStream);
            jpegEncoder.encode(challenge);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (CaptchaServiceException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
        return new StreamingResolution("image/jpeg",
                new ByteArrayInputStream(captchaChallengeAsJpeg));
    }
}