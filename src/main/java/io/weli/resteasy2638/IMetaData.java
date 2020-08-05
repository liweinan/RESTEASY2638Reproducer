package io.weli.resteasy2638;

import org.jboss.resteasy.plugins.providers.jsonb.DeserializeAs;

@DeserializeAs(MetaData.class)
public interface IMetaData {
    String getMetaInfo();
}