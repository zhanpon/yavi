/*
 * Copyright (C) 2018-2019 Toshiaki Maki <makingx@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package am.ik.yavi.constraint;

import java.util.function.Predicate;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ShortConstraintTest {
	private ShortConstraint<Short> constraint = new ShortConstraint<>();

	@Test
	public void greaterThan() {
		Predicate<Short> predicate = constraint.greaterThan((short) 100).predicates()
				.peekFirst().predicate();
		assertThat(predicate.test((short) 101)).isTrue();
		assertThat(predicate.test((short) 100)).isFalse();
	}

	@Test
	public void greaterThanOrEqual() {
		Predicate<Short> predicate = constraint.greaterThanOrEqual((short) 100)
				.predicates().peekFirst().predicate();
		assertThat(predicate.test((short) 101)).isTrue();
		assertThat(predicate.test((short) 100)).isTrue();
		assertThat(predicate.test((short) 99)).isFalse();
	}

	@Test
	public void lessThan() {
		Predicate<Short> predicate = constraint.lessThan((short) 100).predicates()
				.peekFirst().predicate();
		assertThat(predicate.test((short) 99)).isTrue();
		assertThat(predicate.test((short) 100)).isFalse();
	}

	@Test
	public void lessThanOrEqual() {
		Predicate<Short> predicate = constraint.lessThanOrEqual((short) 100).predicates()
				.peekFirst().predicate();
		assertThat(predicate.test((short) 99)).isTrue();
		assertThat(predicate.test((short) 100)).isTrue();
		assertThat(predicate.test((short) 101)).isFalse();
	}
}
