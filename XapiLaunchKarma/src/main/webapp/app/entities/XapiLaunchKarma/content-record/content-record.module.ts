import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { XapiLaunchKarmaSharedModule } from 'app/shared';
import {
  ContentRecordComponent,
  ContentRecordDetailComponent,
  ContentRecordUpdateComponent,
  ContentRecordDeletePopupComponent,
  ContentRecordDeleteDialogComponent,
  contentRecordRoute,
  contentRecordPopupRoute
} from './';

const ENTITY_STATES = [...contentRecordRoute, ...contentRecordPopupRoute];

@NgModule({
  imports: [XapiLaunchKarmaSharedModule, RouterModule.forChild(ENTITY_STATES)],
  declarations: [
    ContentRecordComponent,
    ContentRecordDetailComponent,
    ContentRecordUpdateComponent,
    ContentRecordDeleteDialogComponent,
    ContentRecordDeletePopupComponent
  ],
  entryComponents: [
    ContentRecordComponent,
    ContentRecordUpdateComponent,
    ContentRecordDeleteDialogComponent,
    ContentRecordDeletePopupComponent
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class XapiLaunchKarmaContentRecordModule {}
