/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class SimpleObject extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -1285820761503169005L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"SimpleObject\",\"fields\":[{\"name\":\"name\",\"type\":\"string\"},{\"name\":\"value\",\"type\":\"string\"},{\"name\":\"age\",\"type\":\"int\"},{\"name\":\"mail\",\"type\":\"string\"},{\"name\":\"score\",\"type\":\"double\"},{\"name\":\"height\",\"type\":\"double\"},{\"name\":\"weight\",\"type\":\"double\"},{\"name\":\"school\",\"type\":\"string\"},{\"name\":\"teacher\",\"type\":\"string\"},{\"name\":\"parents\",\"type\":{\"type\":\"array\",\"items\":\"string\"}},{\"name\":\"desc\",\"type\":\"string\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<SimpleObject> ENCODER =
      new BinaryMessageEncoder<>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<SimpleObject> DECODER =
      new BinaryMessageDecoder<>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<SimpleObject> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<SimpleObject> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<SimpleObject> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this SimpleObject to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a SimpleObject from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a SimpleObject instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static SimpleObject fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private java.lang.CharSequence name;
  private java.lang.CharSequence value;
  private int age;
  private java.lang.CharSequence mail;
  private double score;
  private double height;
  private double weight;
  private java.lang.CharSequence school;
  private java.lang.CharSequence teacher;
  private java.util.List<java.lang.CharSequence> parents;
  private java.lang.CharSequence desc;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public SimpleObject() {}

  /**
   * All-args constructor.
   * @param name The new value for name
   * @param value The new value for value
   * @param age The new value for age
   * @param mail The new value for mail
   * @param score The new value for score
   * @param height The new value for height
   * @param weight The new value for weight
   * @param school The new value for school
   * @param teacher The new value for teacher
   * @param parents The new value for parents
   * @param desc The new value for desc
   */
  public SimpleObject(java.lang.CharSequence name, java.lang.CharSequence value, java.lang.Integer age, java.lang.CharSequence mail, java.lang.Double score, java.lang.Double height, java.lang.Double weight, java.lang.CharSequence school, java.lang.CharSequence teacher, java.util.List<java.lang.CharSequence> parents, java.lang.CharSequence desc) {
    this.name = name;
    this.value = value;
    this.age = age;
    this.mail = mail;
    this.score = score;
    this.height = height;
    this.weight = weight;
    this.school = school;
    this.teacher = teacher;
    this.parents = parents;
    this.desc = desc;
  }

  @Override
  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }

  @Override
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }

  // Used by DatumWriter.  Applications should not call.
  @Override
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return name;
    case 1: return value;
    case 2: return age;
    case 3: return mail;
    case 4: return score;
    case 5: return height;
    case 6: return weight;
    case 7: return school;
    case 8: return teacher;
    case 9: return parents;
    case 10: return desc;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @Override
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: name = (java.lang.CharSequence)value$; break;
    case 1: value = (java.lang.CharSequence)value$; break;
    case 2: age = (java.lang.Integer)value$; break;
    case 3: mail = (java.lang.CharSequence)value$; break;
    case 4: score = (java.lang.Double)value$; break;
    case 5: height = (java.lang.Double)value$; break;
    case 6: weight = (java.lang.Double)value$; break;
    case 7: school = (java.lang.CharSequence)value$; break;
    case 8: teacher = (java.lang.CharSequence)value$; break;
    case 9: parents = (java.util.List<java.lang.CharSequence>)value$; break;
    case 10: desc = (java.lang.CharSequence)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'name' field.
   * @return The value of the 'name' field.
   */
  public java.lang.CharSequence getName() {
    return name;
  }


  /**
   * Sets the value of the 'name' field.
   * @param value the value to set.
   */
  public void setName(java.lang.CharSequence value) {
    this.name = value;
  }

  /**
   * Gets the value of the 'value' field.
   * @return The value of the 'value' field.
   */
  public java.lang.CharSequence getValue() {
    return value;
  }


  /**
   * Sets the value of the 'value' field.
   * @param value the value to set.
   */
  public void setValue(java.lang.CharSequence value) {
    this.value = value;
  }

  /**
   * Gets the value of the 'age' field.
   * @return The value of the 'age' field.
   */
  public int getAge() {
    return age;
  }


  /**
   * Sets the value of the 'age' field.
   * @param value the value to set.
   */
  public void setAge(int value) {
    this.age = value;
  }

  /**
   * Gets the value of the 'mail' field.
   * @return The value of the 'mail' field.
   */
  public java.lang.CharSequence getMail() {
    return mail;
  }


  /**
   * Sets the value of the 'mail' field.
   * @param value the value to set.
   */
  public void setMail(java.lang.CharSequence value) {
    this.mail = value;
  }

  /**
   * Gets the value of the 'score' field.
   * @return The value of the 'score' field.
   */
  public double getScore() {
    return score;
  }


  /**
   * Sets the value of the 'score' field.
   * @param value the value to set.
   */
  public void setScore(double value) {
    this.score = value;
  }

  /**
   * Gets the value of the 'height' field.
   * @return The value of the 'height' field.
   */
  public double getHeight() {
    return height;
  }


  /**
   * Sets the value of the 'height' field.
   * @param value the value to set.
   */
  public void setHeight(double value) {
    this.height = value;
  }

  /**
   * Gets the value of the 'weight' field.
   * @return The value of the 'weight' field.
   */
  public double getWeight() {
    return weight;
  }


  /**
   * Sets the value of the 'weight' field.
   * @param value the value to set.
   */
  public void setWeight(double value) {
    this.weight = value;
  }

  /**
   * Gets the value of the 'school' field.
   * @return The value of the 'school' field.
   */
  public java.lang.CharSequence getSchool() {
    return school;
  }


  /**
   * Sets the value of the 'school' field.
   * @param value the value to set.
   */
  public void setSchool(java.lang.CharSequence value) {
    this.school = value;
  }

  /**
   * Gets the value of the 'teacher' field.
   * @return The value of the 'teacher' field.
   */
  public java.lang.CharSequence getTeacher() {
    return teacher;
  }


  /**
   * Sets the value of the 'teacher' field.
   * @param value the value to set.
   */
  public void setTeacher(java.lang.CharSequence value) {
    this.teacher = value;
  }

  /**
   * Gets the value of the 'parents' field.
   * @return The value of the 'parents' field.
   */
  public java.util.List<java.lang.CharSequence> getParents() {
    return parents;
  }


  /**
   * Sets the value of the 'parents' field.
   * @param value the value to set.
   */
  public void setParents(java.util.List<java.lang.CharSequence> value) {
    this.parents = value;
  }

  /**
   * Gets the value of the 'desc' field.
   * @return The value of the 'desc' field.
   */
  public java.lang.CharSequence getDesc() {
    return desc;
  }


  /**
   * Sets the value of the 'desc' field.
   * @param value the value to set.
   */
  public void setDesc(java.lang.CharSequence value) {
    this.desc = value;
  }

  /**
   * Creates a new SimpleObject RecordBuilder.
   * @return A new SimpleObject RecordBuilder
   */
  public static SimpleObject.Builder newBuilder() {
    return new SimpleObject.Builder();
  }

  /**
   * Creates a new SimpleObject RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new SimpleObject RecordBuilder
   */
  public static SimpleObject.Builder newBuilder(SimpleObject.Builder other) {
    if (other == null) {
      return new SimpleObject.Builder();
    } else {
      return new SimpleObject.Builder(other);
    }
  }

  /**
   * Creates a new SimpleObject RecordBuilder by copying an existing SimpleObject instance.
   * @param other The existing instance to copy.
   * @return A new SimpleObject RecordBuilder
   */
  public static SimpleObject.Builder newBuilder(SimpleObject other) {
    if (other == null) {
      return new SimpleObject.Builder();
    } else {
      return new SimpleObject.Builder(other);
    }
  }

  /**
   * RecordBuilder for SimpleObject instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<SimpleObject>
    implements org.apache.avro.data.RecordBuilder<SimpleObject> {

    private java.lang.CharSequence name;
    private java.lang.CharSequence value;
    private int age;
    private java.lang.CharSequence mail;
    private double score;
    private double height;
    private double weight;
    private java.lang.CharSequence school;
    private java.lang.CharSequence teacher;
    private java.util.List<java.lang.CharSequence> parents;
    private java.lang.CharSequence desc;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(SimpleObject.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.name)) {
        this.name = data().deepCopy(fields()[0].schema(), other.name);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.value)) {
        this.value = data().deepCopy(fields()[1].schema(), other.value);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.age)) {
        this.age = data().deepCopy(fields()[2].schema(), other.age);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.mail)) {
        this.mail = data().deepCopy(fields()[3].schema(), other.mail);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.score)) {
        this.score = data().deepCopy(fields()[4].schema(), other.score);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
      if (isValidValue(fields()[5], other.height)) {
        this.height = data().deepCopy(fields()[5].schema(), other.height);
        fieldSetFlags()[5] = other.fieldSetFlags()[5];
      }
      if (isValidValue(fields()[6], other.weight)) {
        this.weight = data().deepCopy(fields()[6].schema(), other.weight);
        fieldSetFlags()[6] = other.fieldSetFlags()[6];
      }
      if (isValidValue(fields()[7], other.school)) {
        this.school = data().deepCopy(fields()[7].schema(), other.school);
        fieldSetFlags()[7] = other.fieldSetFlags()[7];
      }
      if (isValidValue(fields()[8], other.teacher)) {
        this.teacher = data().deepCopy(fields()[8].schema(), other.teacher);
        fieldSetFlags()[8] = other.fieldSetFlags()[8];
      }
      if (isValidValue(fields()[9], other.parents)) {
        this.parents = data().deepCopy(fields()[9].schema(), other.parents);
        fieldSetFlags()[9] = other.fieldSetFlags()[9];
      }
      if (isValidValue(fields()[10], other.desc)) {
        this.desc = data().deepCopy(fields()[10].schema(), other.desc);
        fieldSetFlags()[10] = other.fieldSetFlags()[10];
      }
    }

    /**
     * Creates a Builder by copying an existing SimpleObject instance
     * @param other The existing instance to copy.
     */
    private Builder(SimpleObject other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.name)) {
        this.name = data().deepCopy(fields()[0].schema(), other.name);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.value)) {
        this.value = data().deepCopy(fields()[1].schema(), other.value);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.age)) {
        this.age = data().deepCopy(fields()[2].schema(), other.age);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.mail)) {
        this.mail = data().deepCopy(fields()[3].schema(), other.mail);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.score)) {
        this.score = data().deepCopy(fields()[4].schema(), other.score);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.height)) {
        this.height = data().deepCopy(fields()[5].schema(), other.height);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.weight)) {
        this.weight = data().deepCopy(fields()[6].schema(), other.weight);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.school)) {
        this.school = data().deepCopy(fields()[7].schema(), other.school);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.teacher)) {
        this.teacher = data().deepCopy(fields()[8].schema(), other.teacher);
        fieldSetFlags()[8] = true;
      }
      if (isValidValue(fields()[9], other.parents)) {
        this.parents = data().deepCopy(fields()[9].schema(), other.parents);
        fieldSetFlags()[9] = true;
      }
      if (isValidValue(fields()[10], other.desc)) {
        this.desc = data().deepCopy(fields()[10].schema(), other.desc);
        fieldSetFlags()[10] = true;
      }
    }

    /**
      * Gets the value of the 'name' field.
      * @return The value.
      */
    public java.lang.CharSequence getName() {
      return name;
    }


    /**
      * Sets the value of the 'name' field.
      * @param value The value of 'name'.
      * @return This builder.
      */
    public SimpleObject.Builder setName(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.name = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'name' field has been set.
      * @return True if the 'name' field has been set, false otherwise.
      */
    public boolean hasName() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'name' field.
      * @return This builder.
      */
    public SimpleObject.Builder clearName() {
      name = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'value' field.
      * @return The value.
      */
    public java.lang.CharSequence getValue() {
      return value;
    }


    /**
      * Sets the value of the 'value' field.
      * @param value The value of 'value'.
      * @return This builder.
      */
    public SimpleObject.Builder setValue(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.value = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'value' field has been set.
      * @return True if the 'value' field has been set, false otherwise.
      */
    public boolean hasValue() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'value' field.
      * @return This builder.
      */
    public SimpleObject.Builder clearValue() {
      value = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'age' field.
      * @return The value.
      */
    public int getAge() {
      return age;
    }


    /**
      * Sets the value of the 'age' field.
      * @param value The value of 'age'.
      * @return This builder.
      */
    public SimpleObject.Builder setAge(int value) {
      validate(fields()[2], value);
      this.age = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'age' field has been set.
      * @return True if the 'age' field has been set, false otherwise.
      */
    public boolean hasAge() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'age' field.
      * @return This builder.
      */
    public SimpleObject.Builder clearAge() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'mail' field.
      * @return The value.
      */
    public java.lang.CharSequence getMail() {
      return mail;
    }


    /**
      * Sets the value of the 'mail' field.
      * @param value The value of 'mail'.
      * @return This builder.
      */
    public SimpleObject.Builder setMail(java.lang.CharSequence value) {
      validate(fields()[3], value);
      this.mail = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'mail' field has been set.
      * @return True if the 'mail' field has been set, false otherwise.
      */
    public boolean hasMail() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'mail' field.
      * @return This builder.
      */
    public SimpleObject.Builder clearMail() {
      mail = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'score' field.
      * @return The value.
      */
    public double getScore() {
      return score;
    }


    /**
      * Sets the value of the 'score' field.
      * @param value The value of 'score'.
      * @return This builder.
      */
    public SimpleObject.Builder setScore(double value) {
      validate(fields()[4], value);
      this.score = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'score' field has been set.
      * @return True if the 'score' field has been set, false otherwise.
      */
    public boolean hasScore() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'score' field.
      * @return This builder.
      */
    public SimpleObject.Builder clearScore() {
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'height' field.
      * @return The value.
      */
    public double getHeight() {
      return height;
    }


    /**
      * Sets the value of the 'height' field.
      * @param value The value of 'height'.
      * @return This builder.
      */
    public SimpleObject.Builder setHeight(double value) {
      validate(fields()[5], value);
      this.height = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'height' field has been set.
      * @return True if the 'height' field has been set, false otherwise.
      */
    public boolean hasHeight() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'height' field.
      * @return This builder.
      */
    public SimpleObject.Builder clearHeight() {
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
      * Gets the value of the 'weight' field.
      * @return The value.
      */
    public double getWeight() {
      return weight;
    }


    /**
      * Sets the value of the 'weight' field.
      * @param value The value of 'weight'.
      * @return This builder.
      */
    public SimpleObject.Builder setWeight(double value) {
      validate(fields()[6], value);
      this.weight = value;
      fieldSetFlags()[6] = true;
      return this;
    }

    /**
      * Checks whether the 'weight' field has been set.
      * @return True if the 'weight' field has been set, false otherwise.
      */
    public boolean hasWeight() {
      return fieldSetFlags()[6];
    }


    /**
      * Clears the value of the 'weight' field.
      * @return This builder.
      */
    public SimpleObject.Builder clearWeight() {
      fieldSetFlags()[6] = false;
      return this;
    }

    /**
      * Gets the value of the 'school' field.
      * @return The value.
      */
    public java.lang.CharSequence getSchool() {
      return school;
    }


    /**
      * Sets the value of the 'school' field.
      * @param value The value of 'school'.
      * @return This builder.
      */
    public SimpleObject.Builder setSchool(java.lang.CharSequence value) {
      validate(fields()[7], value);
      this.school = value;
      fieldSetFlags()[7] = true;
      return this;
    }

    /**
      * Checks whether the 'school' field has been set.
      * @return True if the 'school' field has been set, false otherwise.
      */
    public boolean hasSchool() {
      return fieldSetFlags()[7];
    }


    /**
      * Clears the value of the 'school' field.
      * @return This builder.
      */
    public SimpleObject.Builder clearSchool() {
      school = null;
      fieldSetFlags()[7] = false;
      return this;
    }

    /**
      * Gets the value of the 'teacher' field.
      * @return The value.
      */
    public java.lang.CharSequence getTeacher() {
      return teacher;
    }


    /**
      * Sets the value of the 'teacher' field.
      * @param value The value of 'teacher'.
      * @return This builder.
      */
    public SimpleObject.Builder setTeacher(java.lang.CharSequence value) {
      validate(fields()[8], value);
      this.teacher = value;
      fieldSetFlags()[8] = true;
      return this;
    }

    /**
      * Checks whether the 'teacher' field has been set.
      * @return True if the 'teacher' field has been set, false otherwise.
      */
    public boolean hasTeacher() {
      return fieldSetFlags()[8];
    }


    /**
      * Clears the value of the 'teacher' field.
      * @return This builder.
      */
    public SimpleObject.Builder clearTeacher() {
      teacher = null;
      fieldSetFlags()[8] = false;
      return this;
    }

    /**
      * Gets the value of the 'parents' field.
      * @return The value.
      */
    public java.util.List<java.lang.CharSequence> getParents() {
      return parents;
    }


    /**
      * Sets the value of the 'parents' field.
      * @param value The value of 'parents'.
      * @return This builder.
      */
    public SimpleObject.Builder setParents(java.util.List<java.lang.CharSequence> value) {
      validate(fields()[9], value);
      this.parents = value;
      fieldSetFlags()[9] = true;
      return this;
    }

    /**
      * Checks whether the 'parents' field has been set.
      * @return True if the 'parents' field has been set, false otherwise.
      */
    public boolean hasParents() {
      return fieldSetFlags()[9];
    }


    /**
      * Clears the value of the 'parents' field.
      * @return This builder.
      */
    public SimpleObject.Builder clearParents() {
      parents = null;
      fieldSetFlags()[9] = false;
      return this;
    }

    /**
      * Gets the value of the 'desc' field.
      * @return The value.
      */
    public java.lang.CharSequence getDesc() {
      return desc;
    }


    /**
      * Sets the value of the 'desc' field.
      * @param value The value of 'desc'.
      * @return This builder.
      */
    public SimpleObject.Builder setDesc(java.lang.CharSequence value) {
      validate(fields()[10], value);
      this.desc = value;
      fieldSetFlags()[10] = true;
      return this;
    }

    /**
      * Checks whether the 'desc' field has been set.
      * @return True if the 'desc' field has been set, false otherwise.
      */
    public boolean hasDesc() {
      return fieldSetFlags()[10];
    }


    /**
      * Clears the value of the 'desc' field.
      * @return This builder.
      */
    public SimpleObject.Builder clearDesc() {
      desc = null;
      fieldSetFlags()[10] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public SimpleObject build() {
      try {
        SimpleObject record = new SimpleObject();
        record.name = fieldSetFlags()[0] ? this.name : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.value = fieldSetFlags()[1] ? this.value : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.age = fieldSetFlags()[2] ? this.age : (java.lang.Integer) defaultValue(fields()[2]);
        record.mail = fieldSetFlags()[3] ? this.mail : (java.lang.CharSequence) defaultValue(fields()[3]);
        record.score = fieldSetFlags()[4] ? this.score : (java.lang.Double) defaultValue(fields()[4]);
        record.height = fieldSetFlags()[5] ? this.height : (java.lang.Double) defaultValue(fields()[5]);
        record.weight = fieldSetFlags()[6] ? this.weight : (java.lang.Double) defaultValue(fields()[6]);
        record.school = fieldSetFlags()[7] ? this.school : (java.lang.CharSequence) defaultValue(fields()[7]);
        record.teacher = fieldSetFlags()[8] ? this.teacher : (java.lang.CharSequence) defaultValue(fields()[8]);
        record.parents = fieldSetFlags()[9] ? this.parents : (java.util.List<java.lang.CharSequence>) defaultValue(fields()[9]);
        record.desc = fieldSetFlags()[10] ? this.desc : (java.lang.CharSequence) defaultValue(fields()[10]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<SimpleObject>
    WRITER$ = (org.apache.avro.io.DatumWriter<SimpleObject>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<SimpleObject>
    READER$ = (org.apache.avro.io.DatumReader<SimpleObject>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.name);

    out.writeString(this.value);

    out.writeInt(this.age);

    out.writeString(this.mail);

    out.writeDouble(this.score);

    out.writeDouble(this.height);

    out.writeDouble(this.weight);

    out.writeString(this.school);

    out.writeString(this.teacher);

    long size0 = this.parents.size();
    out.writeArrayStart();
    out.setItemCount(size0);
    long actualSize0 = 0;
    for (java.lang.CharSequence e0: this.parents) {
      actualSize0++;
      out.startItem();
      out.writeString(e0);
    }
    out.writeArrayEnd();
    if (actualSize0 != size0)
      throw new java.util.ConcurrentModificationException("Array-size written was " + size0 + ", but element count was " + actualSize0 + ".");

    out.writeString(this.desc);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.name = in.readString(this.name instanceof Utf8 ? (Utf8)this.name : null);

      this.value = in.readString(this.value instanceof Utf8 ? (Utf8)this.value : null);

      this.age = in.readInt();

      this.mail = in.readString(this.mail instanceof Utf8 ? (Utf8)this.mail : null);

      this.score = in.readDouble();

      this.height = in.readDouble();

      this.weight = in.readDouble();

      this.school = in.readString(this.school instanceof Utf8 ? (Utf8)this.school : null);

      this.teacher = in.readString(this.teacher instanceof Utf8 ? (Utf8)this.teacher : null);

      long size0 = in.readArrayStart();
      java.util.List<java.lang.CharSequence> a0 = this.parents;
      if (a0 == null) {
        a0 = new SpecificData.Array<java.lang.CharSequence>((int)size0, SCHEMA$.getField("parents").schema());
        this.parents = a0;
      } else a0.clear();
      SpecificData.Array<java.lang.CharSequence> ga0 = (a0 instanceof SpecificData.Array ? (SpecificData.Array<java.lang.CharSequence>)a0 : null);
      for ( ; 0 < size0; size0 = in.arrayNext()) {
        for ( ; size0 != 0; size0--) {
          java.lang.CharSequence e0 = (ga0 != null ? ga0.peek() : null);
          e0 = in.readString(e0 instanceof Utf8 ? (Utf8)e0 : null);
          a0.add(e0);
        }
      }

      this.desc = in.readString(this.desc instanceof Utf8 ? (Utf8)this.desc : null);

    } else {
      for (int i = 0; i < 11; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.name = in.readString(this.name instanceof Utf8 ? (Utf8)this.name : null);
          break;

        case 1:
          this.value = in.readString(this.value instanceof Utf8 ? (Utf8)this.value : null);
          break;

        case 2:
          this.age = in.readInt();
          break;

        case 3:
          this.mail = in.readString(this.mail instanceof Utf8 ? (Utf8)this.mail : null);
          break;

        case 4:
          this.score = in.readDouble();
          break;

        case 5:
          this.height = in.readDouble();
          break;

        case 6:
          this.weight = in.readDouble();
          break;

        case 7:
          this.school = in.readString(this.school instanceof Utf8 ? (Utf8)this.school : null);
          break;

        case 8:
          this.teacher = in.readString(this.teacher instanceof Utf8 ? (Utf8)this.teacher : null);
          break;

        case 9:
          long size0 = in.readArrayStart();
          java.util.List<java.lang.CharSequence> a0 = this.parents;
          if (a0 == null) {
            a0 = new SpecificData.Array<java.lang.CharSequence>((int)size0, SCHEMA$.getField("parents").schema());
            this.parents = a0;
          } else a0.clear();
          SpecificData.Array<java.lang.CharSequence> ga0 = (a0 instanceof SpecificData.Array ? (SpecificData.Array<java.lang.CharSequence>)a0 : null);
          for ( ; 0 < size0; size0 = in.arrayNext()) {
            for ( ; size0 != 0; size0--) {
              java.lang.CharSequence e0 = (ga0 != null ? ga0.peek() : null);
              e0 = in.readString(e0 instanceof Utf8 ? (Utf8)e0 : null);
              a0.add(e0);
            }
          }
          break;

        case 10:
          this.desc = in.readString(this.desc instanceof Utf8 ? (Utf8)this.desc : null);
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}









