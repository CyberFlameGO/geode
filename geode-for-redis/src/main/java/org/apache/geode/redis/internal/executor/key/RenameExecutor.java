/*
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license
 * agreements. See the NOTICE file distributed with this work for additional information regarding
 * copyright ownership. The ASF licenses this file to You under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License. You may obtain a
 * copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 *
 */

package org.apache.geode.redis.internal.executor.key;

import org.apache.logging.log4j.Logger;

import org.apache.geode.logging.internal.log4j.api.LogService;
import org.apache.geode.redis.internal.data.RedisKey;
import org.apache.geode.redis.internal.executor.RedisResponse;
import org.apache.geode.redis.internal.netty.ExecutionHandlerContext;

public class RenameExecutor extends AbstractRenameExecutor {
  private static final Logger logger = LogService.getLogger();

  @Override
  protected boolean executeRenameCommand(RedisKey key, RedisKey newKey,
      ExecutionHandlerContext context) {
    logger.error("RENAME, args are:" + key + " " + newKey);
    return rename(context, key, newKey, false);
  }

  @Override
  protected RedisResponse getTargetSameAsSourceResponse() {
    return getSuccessResponse();
  }

  @Override
  protected RedisResponse getSuccessResponse() {
    return RedisResponse.ok();
  }

  @Override
  protected RedisResponse getKeyExistsResponse() {
    throw new AssertionError(
        "RENAME allows existing target key so this method should never be called");
  }

}
