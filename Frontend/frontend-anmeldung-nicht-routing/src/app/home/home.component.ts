
import { ChangeDetectionStrategy, Component, inject } from '@angular/core';
import { FloatLabelType, MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { toSignal } from '@angular/core/rxjs-interop';
import { FormBuilder, FormControl, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatRadioModule } from '@angular/material/radio';
import { MatSelectModule } from '@angular/material/select';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { provideNativeDateAdapter } from '@angular/material/core';
import { map } from 'rxjs/operators';

@Component( {
  selector: 'app-home',
  standalone: true,
  imports: [
    MatFormFieldModule,
    MatInputModule,
    MatIconModule,
    FormsModule,
    ReactiveFormsModule,
    MatCheckboxModule,
    MatRadioModule,
    MatFormFieldModule,
    MatInputModule,
    MatSelectModule,
    MatIconModule,
    MatInputModule,
    MatDatepickerModule ],
  providers: [ provideNativeDateAdapter() ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss',
  changeDetection: ChangeDetectionStrategy.OnPush,
} )
export class HomeComponent {
  readonly hideRequiredControl = new FormControl( false );
  readonly floatLabelControl = new FormControl( 'auto' as FloatLabelType );
  readonly options = inject( FormBuilder ).group( {
    hideRequired: this.hideRequiredControl,
    floatLabel: this.floatLabelControl,
  } );
  protected readonly hideRequired = toSignal( this.hideRequiredControl.valueChanges );
  protected readonly floatLabel = toSignal(
    this.floatLabelControl.valueChanges.pipe( map( v => v || 'auto' ) ),
    { initialValue: 'auto' },
  );
}