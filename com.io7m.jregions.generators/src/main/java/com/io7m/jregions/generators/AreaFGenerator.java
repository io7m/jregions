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

package com.io7m.jregions.generators;

import java.util.Objects;
import com.io7m.jregions.core.unparameterized.areas.AreaF;
import net.java.quickcheck.Generator;
import net.java.quickcheck.generator.PrimitiveGenerators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A generator for areas.
 */

public final class AreaFGenerator implements Generator<AreaF>
{
  private final Generator<Float> gen;

  /**
   * Create a new generator.
   *
   * @param in_gen A number generator
   */

  public AreaFGenerator(
    final Generator<Float> in_gen)
  {
    this.gen = Objects.requireNonNull(in_gen, "gen");
  }

  /**
   * @return A generator initialized with useful defaults
   */

  public static AreaFGenerator create()
  {
    final Generator<Double> base = PrimitiveGenerators.doubles(0.0, 10000.0);
    return new AreaFGenerator(() -> Float.valueOf(base.next().floatValue()));
  }

  @Override
  public AreaF next()
  {
    final List<Float> order = new ArrayList<>(2);
    order.add(this.gen.next());
    order.add(this.gen.next());
    Collections.sort(order);

    final float x_min = order.get(0).floatValue();
    final float x_max = order.get(1).floatValue();

    order.clear();
    order.add(this.gen.next());
    order.add(this.gen.next());
    Collections.sort(order);

    final float y_min = order.get(0).floatValue();
    final float y_max = order.get(1).floatValue();

    return AreaF.of(x_min, x_max, y_min, y_max);
  }
}
