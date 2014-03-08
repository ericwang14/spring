package hello;

import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 * User: wanggang
 * Date: 3/6/14
 * Time: 9:39 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class DeviceDetectionController {

    @RequestMapping("/detect-device")
    public @ResponseBody String detectDevice(Device device) {
        String deviceType = "unknown";
        if (device.isMobile()) {
            deviceType = "Mobile";
        } else if (device.isNormal()) {
            deviceType = "Normal";
        } else if (device.isTablet()) {
            deviceType = "tablet";
        }
        return "Hello " + deviceType + " browser!";
    }
}
