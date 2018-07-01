/*
 * Copyright © 2017 <code@io7m.com> http://io7m.com
 *
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.
 *
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY
 * SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF OR
 * IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */

package com.io7m.jregions.core.unparameterized.volumes;

import com.io7m.immutables.styles.ImmutablesStyleType;
import com.io7m.jaffirm.core.Preconditions;
import org.immutables.value.Value;

import java.math.BigInteger;

/**
 * <p>A volume with <tt>BigInteger</tt> coordinates.</p>
 *
 * <p>The coordinates of the area are given in <i>half-closed</i> form. That is,
 * {@link #minimumX()} refers to the minimum <i>inclusive</i> value on the X
 * axis, and {@link #maximumX()} refers to the maximum <i>exclusive</i> value on
 * the X axis. Likewise for the Y and Z axes.</p>
 */

@ImmutablesStyleType
@Value.Immutable
public interface VolumeBIType extends VolumeValuesBIType
{
  @Override
  @Value.Parameter(order = 0)
  BigInteger minimumX();

  @Override
  @Value.Parameter(order = 1)
  BigInteger maximumX();

  @Override
  @Value.Parameter(order = 2)
  BigInteger minimumY();

  @Override
  @Value.Parameter(order = 3)
  BigInteger maximumY();

  @Override
  @Value.Parameter(order = 4)
  BigInteger minimumZ();

  @Override
  @Value.Parameter(order = 5)
  BigInteger maximumZ();

  /**
   * Check the preconditions for the parameters.
   */

  @Value.Check
  default void checkPreconditions()
  {
    Preconditions.checkPrecondition(
      this.maximumX(),
      this.maximumX().compareTo(this.minimumX()) >= 0,
      x -> "X maximum must be >= X minimum");
    Preconditions.checkPrecondition(
      this.maximumY(),
      this.maximumY().compareTo(this.minimumY()) >= 0,
      y -> "Y maximum must be >= Y minimum");
    Preconditions.checkPrecondition(
      this.maximumZ(),
      this.maximumZ().compareTo(this.minimumZ()) >= 0,
      z -> "Z maximum must be >= Z minimum");
  }
}
