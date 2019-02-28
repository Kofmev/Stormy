package android.databinding;

public class DataBinderMapperImpl extends MergedDataBinderMapper {
  DataBinderMapperImpl() {
    addMapper(new nl.chefkev.stormy.DataBinderMapperImpl());
  }
}
