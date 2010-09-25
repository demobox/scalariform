package scalariform.formatter

import scalariform.parser._
import scalariform.formatter._

// format: OFF
class CaseClausesFormatterTest extends AbstractExpressionFormatterTest {

  override val debug = false

  """{
    |  case x => x * x
    |  case y => y * 2
    |}""" ==>
  """{
    |  case x => x * x
    |  case y => y * 2
    |}"""

  """{
    |case 1 => // comment
    |2
    |}""" ==>
  """{
    |  case 1 => // comment
    |    2
    |}"""

  """{
    |case x => 
    |while (true) { 
    |1
    |}
    |}""" ==>
  """{
    |  case x =>
    |    while (true) {
    |      1
    |    }
    |}"""

  """a match {
    |    case b => c();
    |d()
    |  }""" ==>
  """a match {
    |  case b =>
    |    c();
    |    d()
    |}"""

  """a match {
    |case b => {
    |c
    |}
    |}""" ==>
  """a match {
    |  case b => {
    |      c
    |    }
    |}""" // TODO: consider one less indent for c and the subsequent } if there's just one BlockExpr in the case (cf following test)

  """a match {
    |case b => {
    |c
    |}
    |d
    |}""" ==>
  """a match {
    |  case b =>
    |    {
    |      c
    |    }
    |    d
    |}"""

  """a match { case a => b; c; d }""" ==>
  """a match { case a => b; c; d }"""

  """a match { case a => b; c;
    |d }""" ==>
  """a match {
    |  case a =>
    |    b; c;
    |    d
    |}"""


}