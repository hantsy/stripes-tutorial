/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial.action;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sourceforge.stripes.action.FileBean;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author hantsy
 */
public class UploadActionBean extends BaseActionBean {

    private final static Log log = LogFactory.getLog(UploadActionBean.class);
    private FileBean uploadFile;
    private long uploadFileSize;

    public long getUploadFileSize() {
        return uploadFileSize;
    }

    public void setUploadFileSize(long uploadFileSize) {
        this.uploadFileSize = uploadFileSize;
    }

    public FileBean getUploadFile() {
        return uploadFile;
    }

    public void setUploadFile(FileBean uploadFile) {
        this.uploadFile = uploadFile;
    }

    public Resolution upload() {
        log.debug("Upload File :" + uploadFile.getFileName());
        log.debug("File size:" + uploadFile.getSize());
        log.debug("File Content type:" + uploadFile.getContentType());
        this.uploadFileSize = uploadFile.getSize();
        String rootPath = getContext().getServletContext().getRealPath("/");
        try {
            uploadFile.save(new File(rootPath + "/public/" + uploadFile.getFileName()));
        } catch (IOException ex) {
            log.debug("Upload file exception, root cause @" + ex);
        }
        return new ForwardResolution("/success.jsp");
    }
}
