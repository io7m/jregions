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

package com.io7m.jregions.tests.core.parameterized;

import com.io7m.jaffirm.core.PreconditionViolationException;
import com.io7m.jregions.core.parameterized.volumes.PVolumeL;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public final class PVolumeLTest
{
  @Test
  public void testIdentities()
  {
    final var volume = PVolumeL.of(0L, 100L, 0L, 100L, 0L, 100L);
    Assertions.assertEquals(0L, volume.minimumX());
    Assertions.assertEquals(0L, volume.minimumY());
    Assertions.assertEquals(0L, volume.minimumZ());
    Assertions.assertEquals(100L, volume.sizeX());
    Assertions.assertEquals(100L, volume.sizeY());
    Assertions.assertEquals(100L, volume.sizeZ());
    Assertions.assertEquals(100L, volume.maximumX());
    Assertions.assertEquals(100L, volume.maximumY());
    Assertions.assertEquals(100L, volume.maximumZ());
  }

  @Test
  public void testBadX()
  {
    final var e = Assertions.assertThrows(
      PreconditionViolationException.class,
      () -> {
        PVolumeL.of(10L, 9L, 0L, 100L, 0L, 100L);
      });
    Assertions.assertTrue(e.getMessage().contains("X"));
  }

  @Test
  public void testBadY()
  {
    final var e = Assertions.assertThrows(
      PreconditionViolationException.class,
      () -> {
        PVolumeL.of(0L, 100L, 10L, 9L, 0L, 100L);
      });
    Assertions.assertTrue(e.getMessage().contains("Y"));
  }

  @Test
  public void testBadZ()
  {
    final var e = Assertions.assertThrows(
      PreconditionViolationException.class,
      () -> {
        PVolumeL.of(0L, 100L, 0L, 100L, 10L, 9L);
      });
    Assertions.assertTrue(e.getMessage().contains("Z"));
  }
}
