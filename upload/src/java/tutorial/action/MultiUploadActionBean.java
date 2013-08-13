/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.FileBean;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author hantsy
 */
public class MultiUploadActionBean extends BaseActionBean {

    private final static Log log = LogFactory.getLog(MultiUploadActionBean.class);
    private List<FileBean> uploadFiles =new ArrayList<FileBean>();

    public List<FileBean> getUploadFiles() {
        return uploadFiles;
    }

    public void setUploadFiles(List<FileBean> uploadFiles) {
        this.uploadFiles = uploadFiles;
    }

    @DefaultHandler
    public Resolution preUpload() {
        return new ForwardResolution("/upload2.jsp");
    }

    public Resolution upload() {

        for (FileBean uploadFile : uploadFiles) {
            if (uploadFile != null) {
                log.debug("Upload File :" + uploadFile.getFileName());
                log.debug("File size:" + uploadFile.getSize());
                String rootPath = getContext().getServletContext().getRealPath("/");
                try {
                    uploadFile.save(new File(rootPath + "/public/" + uploadFile.getFileName()));
                } catch (IOException ex) {
                    log.debug("Upload file exception, root cause @" + ex);
                }
            }
        }

        return new ForwardResolution("/success2.jsp");
    }
}
