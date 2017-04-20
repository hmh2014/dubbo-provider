package com.hmh.dubbo.extbeanfactory;

import org.mongodb.morphia.Morphia;
import org.springframework.beans.factory.config.AbstractFactoryBean;

/**
 * Created by hao on 2017/4/16.
 */
public class MorphiaFactoryBean extends AbstractFactoryBean {

    /**
     * 要扫描的包
     */
    private String[] mapPackages;

    /**
     * 要映射的类
     */
    private String[] mapClasses;

    private boolean ignoreInvalidClasses;

    public String[] getMapPackages() {
        return mapPackages;
    }

    public void setMapPackages(String[] mapPackages) {
        this.mapPackages = mapPackages;
    }

    public String[] getMapClasses() {
        return mapClasses;
    }

    public void setMapClasses(String[] mapClasses) {
        this.mapClasses = mapClasses;
    }

    public boolean isIgnoreInvalidClasses() {
        return ignoreInvalidClasses;
    }

    public void setIgnoreInvalidClasses(boolean ignoreInvalidClasses) {
        this.ignoreInvalidClasses = ignoreInvalidClasses;
    }

    @Override
    public Class<?> getObjectType() {
        return Morphia.class;
    }

    @Override
    protected Morphia createInstance() throws Exception {
        Morphia morphia = new Morphia();
        if (mapPackages != null) {
            for (String packageName: mapPackages) {
                morphia.mapPackage(packageName, ignoreInvalidClasses);
            }
        }
        if (mapClasses != null) {
            for (String entityClass: mapClasses) {
                morphia.map(Class.forName(entityClass));
            }
        }
        return morphia;
    }
}
