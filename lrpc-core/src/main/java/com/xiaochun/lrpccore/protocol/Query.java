package com.xiaochun.lrpccore.protocol;

public class Query {
    private String serviceName;
    private String methodName;
    private Class<?>[] parameterTypes;
    private Object[] args;
    // getter and setter
    public String getServiceName() {
        return serviceName;
    }
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
    public String getMethodName() {
        return methodName;
    }
    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }
    public Class<?>[] getParameterTypes() {
        return parameterTypes;
    }
    public void setParameterTypes(Class<?>[] parameterTypes) {
        this.parameterTypes = parameterTypes;
    }
    public Object[] getArgs() {
        return args;
    }
    public void setArgs(Object[] args) {
        this.args = args;
    }

}