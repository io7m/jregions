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

package com.io7m.jregions.tests.core.unparameterized;

import com.io7m.jregions.core.unparameterized.areas.AreaL;
import com.io7m.jregions.generators.AreaLGenerator;
import com.io7m.junreachable.UnreachableCodeException;
import net.java.quickcheck.Generator;
import net.java.quickcheck.generator.PrimitiveGenerators;
import org.junit.jupiter.api.Assertions;

final class AreasLTestOps
{
  public static final long ZERO = 0;
  public static final long ONE = 1;

  private AreasLTestOps()
  {
    throw new UnreachableCodeException();
  }

  public static void checkEquals(
    final long expected,
    final long actual)
  {
    Assertions.assertEquals(expected, actual);
  }

  public static long constant(
    final String text)
  {
    return Long.parseLong(text);
  }

  public static long absoluteDifference(
    final long m,
    final long n)
  {
    return Math.abs(m - n);
  }

  public static long absolute(
    final long m)
  {
    return Math.abs(m);
  }

  public static long add(
    final long a,
    final long b)
  {
    return a + b;
  }

  public static long maximum(
    final long a,
    final long b)
  {
    return Math.max(a, b);
  }

  public static long minimum(
    final long a,
    final long b)
  {
    return Math.min(a, b);
  }

  public static long subtract(
    final long a,
    final long b)
  {
    return a - b;
  }

  public static long compare(
    final long a,
    final long b)
  {
    return Long.compare(a, b);
  }

  public static long randomBounded(
    final long upper)
  {
    return (long) (Math.random() * upper);
  }

  public static Generator<Long> createWideScalarGenerator()
  {
    final var base =
      PrimitiveGenerators.doubles(-1_000_000.0, 1_000_000.0);
    return () -> Long.valueOf(base.next().longValue());
  }

  public static Generator<Long> createNarrowScalarGenerator()
  {
    final var base =
      PrimitiveGenerators.doubles(-400.0, 400.0);
    return () -> Long.valueOf(base.next().longValue());
  }

  public static Generator<Long> createNarrowNonNegativeScalarGenerator()
  {
    final var base =
      PrimitiveGenerators.doubles(0.0, 400.0);
    return () -> Long.valueOf(base.next().longValue());
  }

  public static Generator<Long> createWideNonNegativeScalarGenerator()
  {
    final var base =
      PrimitiveGenerators.doubles(0.0, 1_000_000.0);
    return () -> Long.valueOf(base.next().longValue());
  }

  public static Generator<AreaL> createGenerator()
  {
    return AreaLGenerator.create();
  }

  public static Generator<AreaL> createParameterizedGenerator(
    final Generator<Long> g)
  {
    return new AreaLGenerator(g);
  }
}
