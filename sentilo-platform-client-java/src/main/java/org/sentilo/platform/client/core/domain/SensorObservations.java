/*
 * Sentilo
 *  
 * Original version 1.4 Copyright (C) 2013 Institut Municipal d’Informàtica, Ajuntament de Barcelona.
 * Modified by Opentrends adding support for multitenant deployments and SaaS. Modifications on version 1.5 Copyright (C) 2015 Opentrends Solucions i Sistemes, S.L.
 * 
 *   
 * This program is licensed and may be used, modified and redistributed under the
 * terms  of the European Public License (EUPL), either version 1.1 or (at your 
 * option) any later version as soon as they are approved by the European 
 * Commission.
 *   
 * Alternatively, you may redistribute and/or modify this program under the terms
 * of the GNU Lesser General Public License as published by the Free Software 
 * Foundation; either  version 3 of the License, or (at your option) any later 
 * version. 
 *   
 * Unless required by applicable law or agreed to in writing, software distributed
 * under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR 
 * CONDITIONS OF ANY KIND, either express or implied. 
 *   
 * See the licenses for the specific language governing permissions, limitations 
 * and more details.
 *   
 * You should have received a copy of the EUPL1.1 and the LGPLv3 licenses along 
 * with this program; if not, you may find them at: 
 *   
 *   https://joinup.ec.europa.eu/software/page/eupl/licence-eupl
 *   http://www.gnu.org/licenses/ 
 *   and 
 *   https://www.gnu.org/licenses/lgpl.txt
 */
package org.sentilo.platform.client.core.domain;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

public class SensorObservations {

  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  private List<Observation> observations;

  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  private String location;

  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  private String sensor;

  public SensorObservations() {
    super();
    observations = new ArrayList<Observation>();
  }

  public SensorObservations(final String sensor) {
    this();
    this.sensor = sensor;
  }

  public SensorObservations(final String sensor, final String location) {
    this(sensor);
    this.location = location;
  }

  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer();
    sb.append("--- Sensor observations ---");
    sb.append("\n\t sensor:").append(sensor);
    if (StringUtils.hasText(location)) {
      sb.append("\n\t location:").append(location);
    }
    if (!CollectionUtils.isEmpty(observations)) {
      sb.append(observations.toString());
    }
    return sb.toString();
  }

  public void addObservation(final Observation observation) {
    observations.add(observation);
  }

  public List<Observation> getObservations() {
    return observations;
  }

  public void setObservations(final List<Observation> observations) {
    this.observations = observations;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(final String location) {
    this.location = location;
  }

  public void setSensor(final String sensor) {
    this.sensor = sensor;
  }

  public String getSensor() {
    return sensor;
  }

}
