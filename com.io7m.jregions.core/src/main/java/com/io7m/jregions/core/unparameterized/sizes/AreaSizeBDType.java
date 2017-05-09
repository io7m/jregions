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

package com.io7m.jregions.core.unparameterized.sizes;

import com.io7m.jaffirm.core.Preconditions;
import com.io7m.jregions.core.JRegionsImmutableStyleType;
import org.immutables.value.Value;

import java.math.BigDecimal;

/**
 * The size of an area with <tt>BigDecimal</tt> coordinates.
 */

@JRegionsImmutableStyleType
@Value.Immutable
public interface AreaSizeBDType extends AreaSizeValuesBDType
{
  @Override
  @Value.Parameter(order = 0)
  BigDecimal sizeX();

  @Override
  @Value.Parameter(order = 1)
  BigDecimal sizeY();

  /**
   * Check preconditions for the type.
   */

  @Value.Check
  default void checkPreconditions()
  {
    Preconditions.checkPrecondition(
      this.sizeX(),
      this.sizeX().compareTo(BigDecimal.ZERO) >= 0,
      d -> "Width must be non-negative");
    Preconditions.checkPrecondition(
      this.sizeY(),
      this.sizeY().compareTo(BigDecimal.ZERO) >= 0,
      d -> "Height must be non-negative");
  }

  /**
   * A builder for size values.
   */

  abstract class Builder
  {
    abstract AreaSizeBD.Builder setSizeX(BigDecimal size_x);

    abstract AreaSizeBD.Builder setSizeY(BigDecimal size_y);

    /**
     * Set the width.
     *
     * @param width The width
     *
     * @return The builder
     *
     * @deprecated Use {@link #setSizeX(BigDecimal)}
     */

    @Deprecated
    public AreaSizeBD.Builder setWidth(
      final BigDecimal width)
    {
      return this.setSizeX(width);
    }

    /**
     * Set the height.
     *
     * @param height The height
     *
     * @return The builder
     *
     * @deprecated Use {@link #setSizeY(BigDecimal)}
     */

    @Deprecated
    public AreaSizeBD.Builder setHeight(
      final BigDecimal height)
    {
      return this.setSizeY(height);
    }
  }
}
