/*
 *  geoserver-streaming-replication
 *  GeoServer Enterprise Extension for cluster architectures
 *  https://github.com/geosdi/geoserver-streaming-replication
 * ====================================================================
 *
 * Copyright (C) 2012-2013 geoSDI Group (CNR IMAA - Potenza - ITALY).
 *
 * This program is free software: you can redistribute it and/or modify it 
 * under the terms of the GNU General Public License as published by 
 * the Free Software Foundation, either version 3 of the License, or 
 * (at your option) any later version. This program is distributed in the 
 * hope that it will be useful, but WITHOUT ANY WARRANTY; without 
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR 
 * A PARTICULAR PURPOSE. See the GNU General Public License 
 * for more details. You should have received a copy of the GNU General 
 * Public License along with this program. If not, see http://www.gnu.org/licenses/ 
 *
 * ====================================================================
 *
 * Linking this library statically or dynamically with other modules is 
 * making a combined work based on this library. Thus, the terms and 
 * conditions of the GNU General Public License cover the whole combination. 
 * 
 * As a special exception, the copyright holders of this library give you permission 
 * to link this library with independent modules to produce an executable, regardless 
 * of the license terms of these independent modules, and to copy and distribute 
 * the resulting executable under terms of your choice, provided that you also meet, 
 * for each linked independent module, the terms and conditions of the license of 
 * that module. An independent module is a module which is not derived from or 
 * based on this library. If you modify this library, you may extend this exception 
 * to your version of the library, but you are not obligated to do so. If you do not 
 * wish to do so, delete this exception statement from your version. 
 *
 */
package org.geosdi.geoservermq.utility;

import org.dozer.DozerBeanMapper;
import org.geosdi.geoservermq.sender.GeoserverSenderMQ;
import org.geoserver.catalog.Catalog;
import org.geoserver.config.util.XStreamPersister;
import org.geoserver.config.util.XStreamPersisterFactory;

/**
 * @author Francesco Izzi - CNR IMAA geoSDI Group
 * @email francesco.izzi@geosdi.org
 * 
 * @author Nazzareno Sileno - CNR IMAA geoSDI Group
 * @email nazzareno.sileno@geosdi.org
 */
public class DependencyBag {

    private XStreamPersisterFactory xpf = new XStreamPersisterFactory();
    private XStreamPersister xp;
    private GeoserverSenderMQ geoserverSender;
    private Catalog catalog;
    private DozerBeanMapper mapper;

    public DependencyBag(GeoserverSenderMQ geoserverSender,
            Catalog catalog, DozerBeanMapper mapper) {
        this.mapper = mapper;
        this.geoserverSender = geoserverSender;
        this.catalog = catalog;
        xp = xpf.createXMLPersister();
        xp.setCatalog(catalog);
    }

    public XStreamPersister getXp() {
        return xp;
    }

    public void setXp(XStreamPersister xp) {
        this.xp = xp;
    }

    public GeoserverSenderMQ getGeoserverSender() {
        return geoserverSender;
    }

    public void setGeoserverSender(GeoserverSenderMQ geoserverSender) {
        this.geoserverSender = geoserverSender;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public DozerBeanMapper getMapper() {
        return mapper;
    }

    public void setMapper(DozerBeanMapper mapper) {
        this.mapper = mapper;
    }
}
