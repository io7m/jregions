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

package com.io7m.jregions.core.parameterized.sizes;

import com.io7m.immutables.styles.ImmutablesStyleType;
import com.io7m.jaffirm.core.Preconditions;
import com.io7m.jregions.core.unparameterized.sizes.AreaSizeValuesDType;
import org.immutables.value.Value;

/**
 * The size of an area with {@code double} coordinates.
 *
 * @param <S> A phantom type parameter indicating the coordinate space of the
 *            area
 */

@ImmutablesStyleType
@Value.Immutable
public interface PAreaSizeDType<S> extends AreaSizeValuesDType
{
  @Override
  @Value.Parameter(order = 0)
  double sizeX();

  @Override
  @Value.Parameter(order = 1)
  double sizeY();

  /**
   * Check preconditions for the type.
   */

  @Value.Check
  default void checkPreconditions()
  {
    Preconditions.checkPreconditionD(
      this.sizeX(), this.sizeX() >= 0.0, d -> "Width must be non-negative");
    Preconditions.checkPreconditionD(
      this.sizeY(), this.sizeY() >= 0.0, d -> "Height must be non-negative");
  }

  /**
   * A builder for size values.
   *
   * @param <S> A phantom type parameter indicating the coordinate space of the
   *            area
   */

  abstract class Builder<S>
  {
    abstract PAreaSizeD.Builder<S> setSizeX(double size_x);

    abstract PAreaSizeD.Builder<S> setSizeY(double size_y);

    /**
     * Set the width.
     *
     * @param width The width
     *
     * @return The builder
     *
     * @deprecated Use {@link #setSizeX(double)}
     */

    @Deprecated
    public final PAreaSizeD.Builder<S> setWidth(
      final double width)
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
     * @deprecated Use {@link #setSizeY(double)}
     */

    @Deprecated
    public final PAreaSizeD.Builder<S> setHeight(
      final double height)
    {
      return this.setSizeY(height);
    }
  }
}
