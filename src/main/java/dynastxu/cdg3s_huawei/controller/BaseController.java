package dynastxu.cdg3s_huawei.controller;

public abstract class BaseController<Service> {
    protected final Service service;

    BaseController(Service service) {
        this.service = service;
    }
}
