package dynastxu.cdg3s_huawei.service;

public abstract class BaseService<Repo> {

    protected Repo repository;

    public BaseService(Repo repository) {
        this.repository = repository;
    }
}
